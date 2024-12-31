package com.socialmedia.app.SocialMediaApp.ServiceImpl;

import com.socialmedia.app.SocialMediaApp.Dtos.PostDtos.PostDtoWIthoutUser;
import com.socialmedia.app.SocialMediaApp.Dtos.UserDtos.UserDtoTile;
import com.socialmedia.app.SocialMediaApp.Dtos.UserDtos.UserDtoWithoutLists;
import com.socialmedia.app.SocialMediaApp.Entities.PostEntity;
import com.socialmedia.app.SocialMediaApp.Entities.User;
import com.socialmedia.app.SocialMediaApp.Exceptions.ResourceNotFoundException;
import com.socialmedia.app.SocialMediaApp.Mapping.PostMapping;
import com.socialmedia.app.SocialMediaApp.Mapping.UserMapping;
import com.socialmedia.app.SocialMediaApp.Repository.UserRepository;
import com.socialmedia.app.SocialMediaApp.Service.UserEntityService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserEntityService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDtoWithoutLists createUser(User user) {
        User savedUser = userRepository.save(user);
        return UserMapping.showUserExcludingLists(savedUser);
    }

    @Override
    public UserDtoWithoutLists updateUser(User user, int id) {
        User foundUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "user id", id));
        user.setAvatarUrl(foundUser.getAvatarUrl());
        user.setUsername("janeSmith");
        user.setPassword("password456");
        user.setAvatarUrl("https://example.com/avatar2.jpg");
        user.setEmail("janesmith@example.com");
        user.setGender("female");
        user.setCreatedAt(LocalDateTime.now());
        user.setBio("Software engineer and book lover");
        user.setPrefferedTheme("light");
        user.setAccountPrivacy("private");
        return createUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDtoWithoutLists> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapping::showUserExcludingLists).toList();

    }

    @Override
    public UserDtoWithoutLists getUserById(int id) {
        User foundUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "user id", id));
        return UserMapping.showUserExcludingLists(foundUser);
    }

    @Override
    public UserDtoWithoutLists followUser(int followerId, int followeeId) {

        //Getting User 1(User to be Followed)
        User user1 = userRepository.findById(followerId).orElseThrow(() -> new ResourceNotFoundException("User", "user id", followerId));
        ;

        //Getting User 2(User to be Followed)
        User user2 = userRepository.findById(followeeId).orElseThrow(() -> new ResourceNotFoundException("User", "user id", followeeId));
        ;

        //User 1 Update
        List<User> followers = user1.getFollowers();
        followers.add(user2);
        user1.setFollowers(followers);
        createUser(user1);

        List<User> followings = user2.getFollowings();
        followings.add(user1);
        user2.setFollowings(followings);
        return createUser(user2);

    }

    @Override
    public List<UserDtoTile> getAllFollowers(int userId) {
        User foundUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
        return foundUser.getFollowers().stream().map(UserMapping::showUserTile).collect(Collectors.toList());
    }

    @Override
    public List<UserDtoTile> getAllFollowings(int userId) {
        User foundUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
        return foundUser.getFollowings().stream().map(UserMapping::showUserTile).collect(Collectors.toList());
    }

    @Override
    public List<PostDtoWIthoutUser> getAllUserPosts(int userId) {
        User foundUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
        List<PostEntity> userPosts = foundUser.getPosts();
        return userPosts.stream().map(PostMapping::convertPostToPostDtoWithoutUser).collect(Collectors.toList());
    }
}

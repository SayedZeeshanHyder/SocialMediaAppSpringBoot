package com.socialmedia.app.SocialMediaApp.Service;

import com.socialmedia.app.SocialMediaApp.Dtos.PostDtos.PostDtoWIthoutUser;
import com.socialmedia.app.SocialMediaApp.Dtos.UserDtos.UserDtoTile;
import com.socialmedia.app.SocialMediaApp.Dtos.UserDtos.UserDtoWithoutLists;
import com.socialmedia.app.SocialMediaApp.Entities.User;

import java.util.List;

public interface UserEntityService {

    UserDtoWithoutLists createUser(User user);

    UserDtoWithoutLists updateUser(User user, int id);

    void deleteUser(int id);

    List<UserDtoWithoutLists> getAllUsers();

    UserDtoWithoutLists getUserById(int id);

    UserDtoWithoutLists followUser(int followerId, int followeeId);

    List<UserDtoTile> getAllFollowers(int userId);

    List<UserDtoTile> getAllFollowings(int userId);

    List<PostDtoWIthoutUser> getAllUserPosts(int userId);
}

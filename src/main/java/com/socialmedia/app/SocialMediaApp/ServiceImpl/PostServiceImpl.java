package com.socialmedia.app.SocialMediaApp.ServiceImpl;

import com.socialmedia.app.SocialMediaApp.Dtos.PostDtos.PostDtoWithoutLists;
import com.socialmedia.app.SocialMediaApp.Entities.PostEntity;
import com.socialmedia.app.SocialMediaApp.Entities.User;
import com.socialmedia.app.SocialMediaApp.Exceptions.ResourceNotFoundException;
import com.socialmedia.app.SocialMediaApp.Mapping.PostMapping;
import com.socialmedia.app.SocialMediaApp.Repository.PostRepository;
import com.socialmedia.app.SocialMediaApp.Repository.UserRepository;
import com.socialmedia.app.SocialMediaApp.Service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PostDtoWithoutLists createPost(PostEntity post, int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        post.setUser(user);
        PostEntity savedPost = postRepository.save(post);
        List<PostEntity> userPosts = user.getPosts();
        userPosts.add(savedPost);
        user.setPosts(userPosts);
        userRepository.save(user);
        return PostMapping.convertPostToPostDtoWithoutLists(savedPost);
    }

    @Override
    public PostDtoWithoutLists getPostById(int postId) {
        PostEntity foundPost = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        return PostMapping.convertPostToPostDtoWithoutLists(foundPost);
    }

    @Override
    public List<PostDtoWithoutLists> getAllPosts() {
        List<PostEntity> posts = postRepository.findAll();
        return posts.stream().map(PostMapping::convertPostToPostDtoWithoutLists).collect(Collectors.toList());
    }

    @Override
    public void deletePostById(int postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public PostDtoWithoutLists updatePost(PostEntity post, int postId) {
        return null;
    }
}

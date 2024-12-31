package com.socialmedia.app.SocialMediaApp.Service;

import com.socialmedia.app.SocialMediaApp.Dtos.PostDtos.PostDtoWithoutLists;
import com.socialmedia.app.SocialMediaApp.Entities.PostEntity;

import java.util.List;

public interface PostService {

    PostDtoWithoutLists createPost(PostEntity post, int userId);

    PostDtoWithoutLists getPostById(int postId);

    List<PostDtoWithoutLists> getAllPosts();

    void deletePostById(int postId);

    PostDtoWithoutLists updatePost(PostEntity post, int postId);
}

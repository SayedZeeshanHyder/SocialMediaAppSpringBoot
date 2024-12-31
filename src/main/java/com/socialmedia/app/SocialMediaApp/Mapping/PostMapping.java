package com.socialmedia.app.SocialMediaApp.Mapping;

import com.socialmedia.app.SocialMediaApp.Dtos.PostDtos.PostDtoWIthoutUser;
import com.socialmedia.app.SocialMediaApp.Dtos.PostDtos.PostDtoWithoutLists;
import com.socialmedia.app.SocialMediaApp.Entities.PostEntity;

public class PostMapping {

    public static PostDtoWithoutLists convertPostToPostDtoWithoutLists(PostEntity post) {
        PostDtoWithoutLists postDtoWithoutLists = new PostDtoWithoutLists();
        postDtoWithoutLists.setId(post.getId());
        postDtoWithoutLists.setTitle(post.getTitle());
        postDtoWithoutLists.setDescription(post.getDescription());
        postDtoWithoutLists.setUserDtoWithoutLists(UserMapping.showUserExcludingLists(post.getUser()));
        postDtoWithoutLists.setContentType(post.getContentType());
        postDtoWithoutLists.setCommentCount(post.getComments().size());
        postDtoWithoutLists.setLikeCount(post.getLikedBy().size());
        postDtoWithoutLists.setUrl(post.getUrl());
        postDtoWithoutLists.setLocation(post.getLocation());
        return postDtoWithoutLists;
    }

    public static PostDtoWIthoutUser convertPostToPostDtoWithoutUser(PostEntity post) {
        PostDtoWIthoutUser postDtoWIthoutUser = new PostDtoWIthoutUser();
        postDtoWIthoutUser.setId(post.getId());
        postDtoWIthoutUser.setTitle(post.getTitle());
        postDtoWIthoutUser.setDescription(post.getDescription());
        postDtoWIthoutUser.setContentType(post.getContentType());
        postDtoWIthoutUser.setCommentCount(post.getComments().size());
        postDtoWIthoutUser.setLikeCount(post.getLikedBy().size());
        postDtoWIthoutUser.setUrl(post.getUrl());
        postDtoWIthoutUser.setLocation(post.getLocation());
        return postDtoWIthoutUser;
    }

}

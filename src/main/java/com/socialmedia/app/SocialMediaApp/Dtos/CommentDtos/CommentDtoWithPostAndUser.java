package com.socialmedia.app.SocialMediaApp.Dtos.CommentDtos;

import com.socialmedia.app.SocialMediaApp.Dtos.PostDtos.PostDtoWIthoutUser;
import com.socialmedia.app.SocialMediaApp.Dtos.UserDtos.UserDtoTile;

import java.time.LocalDateTime;

public class CommentDtoWithPostAndUser {

    private int id;
    private UserDtoTile user;
    private PostDtoWIthoutUser post;
    private String message;
    private int noOfLikes;
    private LocalDateTime createdAt = LocalDateTime.now();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDtoTile getUser() {
        return user;
    }

    public void setUser(UserDtoTile user) {
        this.user = user;
    }

    public PostDtoWIthoutUser getPost() {
        return post;
    }

    public void setPost(PostDtoWIthoutUser post) {
        this.post = post;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNoOfLikes() {
        return noOfLikes;
    }

    public void setNoOfLikes(int noOfLikes) {
        this.noOfLikes = noOfLikes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

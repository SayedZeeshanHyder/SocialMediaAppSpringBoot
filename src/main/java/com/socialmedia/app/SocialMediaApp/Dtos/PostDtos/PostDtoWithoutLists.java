package com.socialmedia.app.SocialMediaApp.Dtos.PostDtos;

import com.socialmedia.app.SocialMediaApp.Dtos.UserDtos.UserDtoWithoutLists;

import java.time.LocalDateTime;


public class PostDtoWithoutLists {

    private int id;
    private LocalDateTime postedAt = LocalDateTime.now();
    private String title;
    private String description;
    private String url;
    private String contentType;
    private String location;
    private UserDtoWithoutLists user;
    private int likeCount;
    private int commentCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserDtoWithoutLists getUserDtoWithoutLists() {
        return user;
    }

    public void setUserDtoWithoutLists(UserDtoWithoutLists userDtoWithoutLists) {
        this.user = userDtoWithoutLists;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}

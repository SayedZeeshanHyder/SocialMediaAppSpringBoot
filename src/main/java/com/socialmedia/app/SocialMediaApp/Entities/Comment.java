package com.socialmedia.app.SocialMediaApp.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String message;
    private int noOfLikes;
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @JoinColumn(name = "commentreplies")
    @OneToMany
    List<CommentReplies> replies = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<CommentReplies> getReplies() {
        return replies;
    }

    public void setReplies(List<CommentReplies> replies) {
        this.replies = replies;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }
}

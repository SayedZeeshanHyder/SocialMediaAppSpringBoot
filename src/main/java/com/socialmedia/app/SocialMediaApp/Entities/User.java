package com.socialmedia.app.SocialMediaApp.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String avatarUrl;
    private String email;
    private String gender;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String bio;
    private String prefferedTheme;
    private String accountPrivacy;

    @ManyToMany
    @JoinTable(
            name = "close_friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "close_friend_id")
    )
    private List<User> closeFriends = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "blocked_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "blocked_user_id")
    )
    private List<User> blockedList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "followings",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "following_id")
    )
    private List<User> followings = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "followers",
            joinColumns = @JoinColumn(name = "following_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> followers = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<PostEntity> posts = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowings() {
        return followings;
    }

    public void setFollowings(List<User> followings) {
        this.followings = followings;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPrefferedTheme() {
        return prefferedTheme;
    }

    public void setPrefferedTheme(String prefferedTheme) {
        this.prefferedTheme = prefferedTheme;
    }

    public String getAccountPrivacy() {
        return accountPrivacy;
    }

    public void setAccountPrivacy(String accountPrivacy) {
        this.accountPrivacy = accountPrivacy;
    }

    public List<User> getCloseFriends() {
        return closeFriends;
    }

    public void setCloseFriends(List<User> closeFriends) {
        this.closeFriends = closeFriends;
    }

    public List<User> getBlockedList() {
        return blockedList;
    }

    public void setBlockedList(List<User> blockedList) {
        this.blockedList = blockedList;
    }

    public List<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntity> posts) {
        this.posts = posts;
    }
}

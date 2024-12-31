package com.socialmedia.app.SocialMediaApp.Mapping;

import com.socialmedia.app.SocialMediaApp.Dtos.UserDtos.UserDtoTile;
import com.socialmedia.app.SocialMediaApp.Dtos.UserDtos.UserDtoWithoutLists;
import com.socialmedia.app.SocialMediaApp.Entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapping {

    public static UserDtoWithoutLists showUserExcludingLists(User user) {
        UserDtoWithoutLists userDtoWithoutLists = new UserDtoWithoutLists();
        userDtoWithoutLists.setFollowerCount(user.getFollowers().size());
        userDtoWithoutLists.setFollowingCount(user.getFollowings().size());
        userDtoWithoutLists.setPostCount(user.getPosts().size());
        userDtoWithoutLists.setAccountPrivacy(user.getAccountPrivacy());
        userDtoWithoutLists.setId(user.getId());
        userDtoWithoutLists.setUsername(user.getUsername());
        userDtoWithoutLists.setAvatarUrl(user.getAvatarUrl());
        userDtoWithoutLists.setEmail(user.getEmail());
        userDtoWithoutLists.setGender(user.getGender());
        userDtoWithoutLists.setCreatedAt(user.getCreatedAt());
        userDtoWithoutLists.setBio(user.getBio());
        userDtoWithoutLists.setPrefferedTheme(user.getPrefferedTheme());
        return userDtoWithoutLists;
    }

    public static UserDtoTile showUserTile(User user) {
        UserDtoTile userDtoTile = new UserDtoTile();
        userDtoTile.setAvatarUrl(user.getAvatarUrl());
        userDtoTile.setEmail(user.getEmail());
        userDtoTile.setUsername(user.getUsername());
        userDtoTile.setId(user.getId());
        return userDtoTile;
    }

}

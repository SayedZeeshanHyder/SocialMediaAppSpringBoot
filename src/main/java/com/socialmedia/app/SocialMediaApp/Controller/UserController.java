package com.socialmedia.app.SocialMediaApp.Controller;

import com.socialmedia.app.SocialMediaApp.Dtos.PostDtos.PostDtoWIthoutUser;
import com.socialmedia.app.SocialMediaApp.Dtos.UserDtos.UserDtoTile;
import com.socialmedia.app.SocialMediaApp.Dtos.UserDtos.UserDtoWithoutLists;
import com.socialmedia.app.SocialMediaApp.Entities.User;
import com.socialmedia.app.SocialMediaApp.Payload.FollowBody;
import com.socialmedia.app.SocialMediaApp.Service.UserEntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserEntityService userEntityService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserEntityService userEntityService, PasswordEncoder passwordEncoder) {
        this.userEntityService = userEntityService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<UserDtoWithoutLists> addUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserDtoWithoutLists savedUser = userEntityService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserDtoWithoutLists> getUser(@PathVariable int userId) {
        UserDtoWithoutLists foundUser = userEntityService.getUserById(userId);
        if (foundUser != null) {
            return ResponseEntity.ok(foundUser);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<UserDtoWithoutLists>> getUsers() {
        List<UserDtoWithoutLists> allUsers = userEntityService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @PostMapping("follow")
    public ResponseEntity<UserDtoWithoutLists> followUser(@RequestBody FollowBody followBody) {
        UserDtoWithoutLists result = userEntityService.followUser(followBody.getFollowerId(), followBody.getFollowingId());
        return ResponseEntity.ok(result);
    }

    @GetMapping("{userId}/followers")
    public ResponseEntity<List<UserDtoTile>> getUserFollowers(@PathVariable int userId) {
        List<UserDtoTile> userFollowers = userEntityService.getAllFollowers(userId);
        return ResponseEntity.ok(userFollowers);
    }

    @GetMapping("{userId}/followings")
    public ResponseEntity<List<UserDtoTile>> getUserFollowings(@PathVariable int userId) {
        List<UserDtoTile> userFollowers = userEntityService.getAllFollowings(userId);
        return ResponseEntity.ok(userFollowers);
    }

    @GetMapping("{userId}/posts")
    public ResponseEntity<List<PostDtoWIthoutUser>> getAllUserPosts(@PathVariable int userId) {
        List<PostDtoWIthoutUser> userPosts = userEntityService.getAllUserPosts(userId);
        return ResponseEntity.ok(userPosts);
    }

}

package com.socialmedia.app.SocialMediaApp.Controller;

import com.socialmedia.app.SocialMediaApp.Dtos.PostDtos.PostDtoWithoutLists;
import com.socialmedia.app.SocialMediaApp.Entities.PostEntity;
import com.socialmedia.app.SocialMediaApp.Payload.ApiResponse;
import com.socialmedia.app.SocialMediaApp.Service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("{userId}")
    public ResponseEntity<PostDtoWithoutLists> createPost(@RequestBody PostEntity postEntity, @PathVariable int userId) {
        PostDtoWithoutLists postDtoWithoutLists = postService.createPost(postEntity, userId);
        return ResponseEntity.ok(postDtoWithoutLists);
    }

    @GetMapping("{postId}")
    public ResponseEntity<PostDtoWithoutLists> getPost(@PathVariable int postId) {
        PostDtoWithoutLists foundPost = postService.getPostById(postId);
        return ResponseEntity.ok(foundPost);
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable int postId) {
        postService.deletePostById(postId);
        return ResponseEntity.ok(new ApiResponse("Post Deleted Successfully", true));
    }
}

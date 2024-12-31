package com.socialmedia.app.SocialMediaApp.Controller;

import com.socialmedia.app.SocialMediaApp.Dtos.CommentDtos.CommentDtoWithPostAndUser;
import com.socialmedia.app.SocialMediaApp.Entities.Comment;
import com.socialmedia.app.SocialMediaApp.Payload.CommentBody;
import com.socialmedia.app.SocialMediaApp.Service.CommentService;
import com.socialmedia.app.SocialMediaApp.Service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDtoWithPostAndUser> createComment(@RequestBody CommentBody commentBody) {
        CommentDtoWithPostAndUser comment = commentService.addComment(commentBody.getComment(), commentBody.getPostId(), commentBody.getUserId());
        return ResponseEntity.ok(comment);
    }
}

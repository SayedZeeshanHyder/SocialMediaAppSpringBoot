package com.socialmedia.app.SocialMediaApp.Service;

import com.socialmedia.app.SocialMediaApp.Dtos.CommentDtos.CommentDtoWithPostAndUser;
import com.socialmedia.app.SocialMediaApp.Entities.Comment;

import java.util.List;

public interface CommentService {

    CommentDtoWithPostAndUser addComment(Comment comment, int postId, int userId);

    CommentDtoWithPostAndUser getCommentById(int id);

    List<CommentDtoWithPostAndUser> getCommentsByPostId(int postId);

    void deleteCommentById(int id);

}

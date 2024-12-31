package com.socialmedia.app.SocialMediaApp.Mapping;

import com.socialmedia.app.SocialMediaApp.Dtos.CommentDtos.CommentDtoWithPostAndUser;
import com.socialmedia.app.SocialMediaApp.Entities.Comment;

public class CommentMapper {

    public static CommentDtoWithPostAndUser convertCommentToCommentDtoWithPostAndUser(Comment comment) {
        CommentDtoWithPostAndUser commentDtoWithPostAndUser = new CommentDtoWithPostAndUser();
        commentDtoWithPostAndUser.setPost(PostMapping.convertPostToPostDtoWithoutUser(comment.getPost()));
        commentDtoWithPostAndUser.setId(comment.getId());
        commentDtoWithPostAndUser.setUser(UserMapping.showUserTile(comment.getUser()));
        commentDtoWithPostAndUser.setMessage(comment.getMessage());
        commentDtoWithPostAndUser.setCreatedAt(comment.getCreatedAt());
        commentDtoWithPostAndUser.setNoOfLikes(comment.getNoOfLikes());
        return commentDtoWithPostAndUser;
    }
}

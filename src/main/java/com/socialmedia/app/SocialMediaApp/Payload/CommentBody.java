package com.socialmedia.app.SocialMediaApp.Payload;

import com.socialmedia.app.SocialMediaApp.Entities.Comment;

public class CommentBody {

    int userId;
    int postId;
    Comment comment;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}

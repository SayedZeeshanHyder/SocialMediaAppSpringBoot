package com.socialmedia.app.SocialMediaApp.Repository;

import com.socialmedia.app.SocialMediaApp.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}

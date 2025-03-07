package com.socialmedia.app.SocialMediaApp.Repository;

import com.socialmedia.app.SocialMediaApp.Entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {
}

package com.socialmedia.app.SocialMediaApp.Repository;

import com.socialmedia.app.SocialMediaApp.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}

package com.socialmedia.app.SocialMediaApp.ServiceImpl;

import com.socialmedia.app.SocialMediaApp.Dtos.CommentDtos.CommentDtoWithPostAndUser;
import com.socialmedia.app.SocialMediaApp.Entities.Comment;
import com.socialmedia.app.SocialMediaApp.Entities.PostEntity;
import com.socialmedia.app.SocialMediaApp.Entities.User;
import com.socialmedia.app.SocialMediaApp.Exceptions.ResourceNotFoundException;
import com.socialmedia.app.SocialMediaApp.Mapping.CommentMapper;
import com.socialmedia.app.SocialMediaApp.Repository.CommentRepository;
import com.socialmedia.app.SocialMediaApp.Repository.PostRepository;
import com.socialmedia.app.SocialMediaApp.Repository.UserRepository;
import com.socialmedia.app.SocialMediaApp.Service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CommentDtoWithPostAndUser addComment(Comment comment, int postId, int userId) {
        PostEntity foundPost = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
        User foundUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        comment.setPost(foundPost);
        comment.setUser(foundUser);
        Comment savedComment = commentRepository.save(comment);
        List<Comment> comments = foundPost.getComments();
        comments.add(savedComment);
        foundPost.setComments(comments);
        postRepository.save(foundPost);
        return CommentMapper.convertCommentToCommentDtoWithPostAndUser(savedComment);
    }

    @Override
    public CommentDtoWithPostAndUser getCommentById(int id) {
        return null;
    }

    @Override
    public List<CommentDtoWithPostAndUser> getCommentsByPostId(int postId) {
        return List.of();
    }

    @Override
    public void deleteCommentById(int id) {

    }
}

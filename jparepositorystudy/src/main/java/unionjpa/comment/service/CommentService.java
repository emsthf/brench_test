package unionjpa.comment.service;

import unionjpa.comment.dto.CommentDto;
import unionjpa.comment.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Comment addComment(CommentDto commentDto);
    List<Comment> getAllComment();
    List<Comment> getAllByUserId(Long userId);
    List<Comment> getAllByPostId(Long postId);
    Optional<Comment> getComment(Long id);
}

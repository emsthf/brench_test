package unionjpa.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unionjpa.comment.model.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByUserId(Long userId);   // 유저 아이디로 해당 유저가 작성한 모든 댓글을 리스트로 검색
    List<Comment> findAllByPostId(Long postId);   // 포스트 아이디로 해당 포스트에 달린 모든 댓글을 리스트로 검색
}

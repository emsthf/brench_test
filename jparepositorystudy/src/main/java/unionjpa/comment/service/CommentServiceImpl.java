package unionjpa.comment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import unionjpa.comment.dto.CommentDto;
import unionjpa.comment.model.Comment;
import unionjpa.comment.repository.CommentRepository;
import unionjpa.post.service.PostService;
import unionjpa.user.service.UserService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final PostService postService;

    @Override
    public Comment addComment(CommentDto commentDto) {
        return commentRepository.save(
                Comment.builder()
                        .commenttext(commentDto.getCommentText())
                        .post(postService.getPostByID(commentDto.getPostId()).get())
                        .user(userService.getUserById(commentDto.getUserId()).get())
                        .build()
        );
    }

    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getAllByUserId(Long userId) {
        return commentRepository.findAllByUserId(userId);
    }

    @Override
    public List<Comment> getAllByPostId(Long postId) {
        return commentRepository.findAllByPostId(postId);
    }

    @Override
    public Optional<Comment> getComment(Long id) {
        return Optional.ofNullable(commentRepository.findById(id).get());
    }
}

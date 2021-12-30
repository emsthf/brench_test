package unionjpa.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import unionjpa.comment.dto.CommentDto;
import unionjpa.comment.model.Comment;
import unionjpa.comment.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/add")
    public Comment addComment(@RequestBody CommentDto commentDto) {
        return commentService.addComment(commentDto);
    }

    @GetMapping("/comment/getAll")
    public List<Comment> getAllComment() {
        return commentService.getAllComment();
    }

    @GetMapping("/comment/getAllByUserId/{userId}")
    public List<Comment> getAllByUserId(@PathVariable Long userId) {
        return commentService.getAllByUserId(userId);
    }

    @GetMapping("/comment/getAllByPostId/{postId}")
    public List<Comment> getAllByPostId(@PathVariable Long postId) {
        return commentService.getAllByPostId(postId);
    }

    @GetMapping("/comment/getComment/{id}")
    public Comment getComment(@PathVariable Long id) {
        return commentService.getComment(id).get();
    }
}

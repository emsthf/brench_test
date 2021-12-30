package unionjpa.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import unionjpa.comment.model.Comment;
import unionjpa.post.dto.PostDto;
import unionjpa.post.model.Post;
import unionjpa.post.service.PostService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    @PostMapping("/post/add")
    public Post addPost(@RequestBody PostDto postDto) {
        return postService.addPost(postDto);
    }

    @GetMapping("/post/getAll")
    public List<Post> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("/post/getPost/{id}")
    public Optional<Post> getPostById(@PathVariable("id") Long id) {
        return postService.getPostByID(id);
    }

    @GetMapping("/post/getPostByAuthorId/{id}")
    public List<Post> getPostByAuthorId(@PathVariable("id") Long id) {
        return postService.getPostByAuthorId(id);
    }

    @GetMapping("/post/getComment/{postId}")
    public List<Comment> getCommentByPostId(@PathVariable Long postId) {
        return postService.getPostByID(postId).get().getCommentList();
    }
}

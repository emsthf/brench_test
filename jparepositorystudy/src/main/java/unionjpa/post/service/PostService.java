package unionjpa.post.service;

import unionjpa.post.dto.PostDto;
import unionjpa.post.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post addPost(PostDto postdto);
    List<Post> getAllPost();
    Optional<Post> getPostByID(Long id);
    List<Post> getPostByAuthorId(Long id);
    void delPost(Long id);
}

package unionjpa.post.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import unionjpa.post.dto.PostDto;
import unionjpa.post.model.Post;
import unionjpa.post.repository.PostRepository;
import unionjpa.user.service.UserService;

import java.util.List;
import java.util.Optional;

@Slf4j   // 로깅 어노테이션
@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {


    private final PostRepository postRepository;
    private final UserService userService;

    @Override
    public Post addPost(@RequestBody PostDto postDto) {
        log.info("save Post.");
        return postRepository.save(
                Post.builder()
                        .postText(postDto.getPostText())
                        .postTitle(postDto.getPostTitle())
                        .user(userService.getUserById(postDto.getUserId()).get())
                        .build()
        );
    }

    @Override
    public List<Post> getAllPost() {
        log.info("");
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostByID(Long id) {
        return Optional.ofNullable(postRepository.findById(id).get());
    }

    @Override
    public List<Post> getPostByAuthorId(Long id) {
        return postRepository.findAllByUserId(id);
    }

    @Override
    public void delPost(Long id) {
        postRepository.deleteById(id);
    }
}

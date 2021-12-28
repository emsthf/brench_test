package unionjpa.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unionjpa.post.model.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUserId(Long id);   // 포스트의 리스트를 유저 id를 통해서 다 가지고 올건데, 나머지 내용은 JPA 레포지토리가 알아서 처리해줌
    // 사실 찾는 것은 AuthorId인데 쿼리는 userId를 던지는 것
}

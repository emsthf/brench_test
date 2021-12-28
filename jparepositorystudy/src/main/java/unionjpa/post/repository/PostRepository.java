package unionjpa.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unionjpa.post.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}

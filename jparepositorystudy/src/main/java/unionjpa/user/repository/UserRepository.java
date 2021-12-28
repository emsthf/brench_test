package unionjpa.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unionjpa.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

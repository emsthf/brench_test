package unionjpa.user.service;

import unionjpa.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);
    List<User> getAllUser();
    Optional<User> getUserById(Long id);
    void delUser(Long id);
}

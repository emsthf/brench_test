package unionjpa.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import unionjpa.user.model.User;
import unionjpa.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Slf4j   // 로그를 뽑아주는 어노테이션
@RequiredArgsConstructor   // 자동 생성자 생성. 이젠 @Autowired 안써도 된다. Autowired보다 이것을 더 권장
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;   // final로 함부로 접근 못하도록.

    @Override
    public User addUser(User user) {
        log.info("Saving new user to the Database. : {}", user.getUserName());   // 유저를 저장할 때 이 로그를 출력
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        log.info("Fetching all users.");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        log.info("Fetching user {}.", id);
        return Optional.ofNullable(userRepository.findById(id).get());
    }

    @Override
    public void delUser(Long id) {
        log.info("Delete user {}.", id);
        userRepository.deleteById(id);
    }
}

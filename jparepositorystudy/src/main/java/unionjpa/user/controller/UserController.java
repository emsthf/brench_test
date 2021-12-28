package unionjpa.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import unionjpa.user.model.User;
import unionjpa.user.service.UserService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor   // 생성자를 생성해주는 어노테이션. @Authwired보다 이것을 쓰는게 좋다
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/user/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/user/getAll")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/user/get/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
}

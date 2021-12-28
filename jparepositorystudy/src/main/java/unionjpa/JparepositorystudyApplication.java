package unionjpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import unionjpa.user.model.User;
import unionjpa.user.service.UserService;

@SpringBootApplication
public class JparepositorystudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(JparepositorystudyApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {   // 스프링이 실행될 때 같이 실행 됨
		return args -> {
			userService.addUser(User.builder()
					.userName("Tim Cook")
					.password("qwer1234")
					.build());
			userService.addUser(User.builder()
					.userName("Steve Jobs")
					.password("123asdfg")
					.build());
			userService.addUser(User.builder()
					.userName("John Kim")
					.password("52939zzz")
					.build());
			userService.addUser(User.builder()
					.userName("The Weeknd")
					.password("gjkdfo111")
					.build());
			userService.addUser(User.builder()
					.userName("Khalid")
					.password("doowjd222")
					.build());
		};
	}
}

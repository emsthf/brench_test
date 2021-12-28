package unionjpa.user.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data   // 데이터 어노테이션은 모두 있는 생성자와 게터/세터만 만들어줌
@NoArgsConstructor   // 빈 생성자 만들어주는 어노테이션
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;

    @Builder
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}

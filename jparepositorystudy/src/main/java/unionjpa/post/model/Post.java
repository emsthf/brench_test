package unionjpa.post.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import unionjpa.user.model.User;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String postTitle;
    private String postText;

    @ManyToOne
    @JoinColumn(name = "author_id")   // 작성자 id
    private User user;

    public User getUser() {
        return user;
    }

    @Builder
    public Post(String postTitle, String postText, User user) {
        this.postTitle = postTitle;
        this.postText = postText;
        this.user = user;
    }
}

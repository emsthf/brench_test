package unionjpa.post.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import unionjpa.comment.model.Comment;
import unionjpa.user.model.User;

import javax.persistence.*;
import java.util.List;

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

    // 포스트 입장에서는 코멘트가 여러개 붙어야 한다. 원(포스트) 투 매니(코멘트)
    // 코멘트 입장에서는 포스트에 매니 투 원으로 붙어있다
    @JsonIgnore   // 원래 주고 받는 값이 Json인데 Json 제외
    @OneToMany(mappedBy = "post")   // mappedBy는 이 테이블 이름.
    private List<Comment> commentList;

    @Builder
    public Post(String postTitle, String postText, User user) {
        this.postTitle = postTitle;
        this.postText = postText;
        this.user = user;
    }
}

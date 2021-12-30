package unionjpa.comment.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import unionjpa.post.model.Post;
import unionjpa.user.model.User;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commenttext;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Comment(String commenttext, Post post, User user) {
        this.commenttext = commenttext;
        this.post = post;
        this.user = user;
    }
}

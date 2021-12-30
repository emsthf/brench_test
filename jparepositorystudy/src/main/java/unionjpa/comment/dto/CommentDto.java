package unionjpa.comment.dto;

import lombok.Data;

@Data
public class CommentDto {
    private String commentText;
    private Long userId;
    private Long postId;
}

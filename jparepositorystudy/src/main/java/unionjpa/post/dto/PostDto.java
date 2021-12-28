package unionjpa.post.dto;

import lombok.Data;

@Data
public class PostDto {

    private String postTitle;
    private String postText;
    private Long userId;
}

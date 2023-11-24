package umc.coffeein.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.coffeein.domain.Comment;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponse {
    private String comment;
    private LocalDateTime createdAt;

    @Builder
    public CommentResponse(Comment comment){
        this.comment = comment.getComment();
        this.createdAt = comment.getCreatedAt();
    }
}

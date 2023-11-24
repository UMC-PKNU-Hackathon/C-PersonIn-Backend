package umc.coffeein.web.dto;

import lombok.Getter;

@Getter
public class PostLikeRequest {
    private Long postId;

    public PostLikeRequest(Long postId){
        this.postId = postId;
    }

}

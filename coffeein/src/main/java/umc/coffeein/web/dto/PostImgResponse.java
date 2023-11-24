package umc.coffeein.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostImgResponse {
    private String imgUrl;

    @Builder
    public PostImgResponse(String imgUrl){
        this.imgUrl = imgUrl;
    }
}

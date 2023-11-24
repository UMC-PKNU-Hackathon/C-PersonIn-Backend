package umc.coffeein.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.coffeein.domain.Post;
import umc.coffeein.domain.PostImg;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class PostResponse {
    private String title;
    private String body;
    private Integer likeCount;
    private LocalDateTime createdAt;

    private List<String> imgUrls;

    // post 정보를 받아 PostResponse 생성
    public PostResponse(Post post) {
        this.title = post.getTitle();
        this.body = post.getBody();
        this.likeCount = post.getLikeCount();
        this.createdAt = post.getCreatedAt();

        this.imgUrls = post.getPostImgs()
                .stream()
                .map(PostImg::getImgUrl)
                .collect(Collectors.toList());
    }
}

package umc.coffeein.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import umc.coffeein.domain.Post;
import umc.coffeein.domain.PostImg;
import umc.coffeein.repository.PostImgRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PostListResponse { // post 전체 목록
    private Long id;
    private String title;
    //private String body;
    private String imgUrl;
    private LocalDateTime createdAt;
    PostImgRepository postImgRepository;


    public PostListResponse(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        System.out.println(post.getPostImgs().size());
        this.imgUrl = post.getPostImgs().get(0).toString();
        this.createdAt = post.getCreatedAt();
    }
    public PostListResponse(Optional<Post> post){
        //this.title = post.get().getTitle();
        this.createdAt = post.get().getCreatedAt();
    }
}

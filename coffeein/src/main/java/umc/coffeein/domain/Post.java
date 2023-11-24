package umc.coffeein.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import umc.coffeein.domain.base.BaseEntity;
import umc.coffeein.web.dto.PostRequest;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false, length = 100)
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostImg> postImgs;

    @Column(name = "likecount", columnDefinition = "integer default 0")
    private Integer likeCount;

    // requestDto 정보를 가져와서 entity 만들 때 사용
    public Post(PostRequest.PostRequestDTO requestDto) {
        this.title = requestDto.getTitle();
        this.body = requestDto.getBody();
    }

    public void setPostImgs(List<PostImg> postImgs) {
        this.postImgs = postImgs;
    }
}

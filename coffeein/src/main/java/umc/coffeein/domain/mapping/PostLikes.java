package umc.coffeein.domain.mapping;

import jakarta.persistence.Entity;
import lombok.*;

import jakarta.persistence.*;
import umc.coffeein.domain.Member;
import umc.coffeein.domain.Post;
import umc.coffeein.domain.HashTag;
import umc.coffeein.domain.base.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PostLikes extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}

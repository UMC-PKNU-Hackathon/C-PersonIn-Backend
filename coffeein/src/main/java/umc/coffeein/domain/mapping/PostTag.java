package umc.coffeein.domain.mapping;

import jakarta.persistence.Entity;
import lombok.*;

import jakarta.persistence.*;
import umc.coffeein.domain.Post;
import umc.coffeein.domain.HashTag;
import umc.coffeein.domain.base.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PostTag extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private HashTag hashTag;
}

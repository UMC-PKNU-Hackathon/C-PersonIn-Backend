package umc.coffeein.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.coffeein.domain.base.BaseEntity;
import umc.coffeein.domain.enums.HashTagEnum;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class HashTag{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

}

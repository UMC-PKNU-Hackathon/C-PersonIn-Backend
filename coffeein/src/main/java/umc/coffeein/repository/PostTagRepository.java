package umc.coffeein.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.coffeein.domain.Comment;
import umc.coffeein.domain.mapping.PostTag;

public interface PostTagRepository extends JpaRepository<PostTag, Long> {
}

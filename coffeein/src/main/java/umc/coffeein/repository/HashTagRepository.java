package umc.coffeein.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.coffeein.domain.HashTag;

public interface HashTagRepository extends JpaRepository<HashTag, Long> {

}

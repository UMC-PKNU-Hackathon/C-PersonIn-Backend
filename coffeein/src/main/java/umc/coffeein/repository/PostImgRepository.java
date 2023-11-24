package umc.coffeein.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.coffeein.domain.PostImg;

public interface PostImgRepository extends JpaRepository<PostImg, Long> {
    @Override
    PostImg getById(Long aLong);
}

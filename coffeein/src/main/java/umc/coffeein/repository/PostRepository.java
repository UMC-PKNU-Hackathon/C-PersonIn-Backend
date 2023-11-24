package umc.coffeein.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.coffeein.domain.Post;
import umc.coffeein.web.dto.PostListResponse;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<PostListResponse> findAllByOrderByCreatedAtDesc(); // post 생성 시간을 기준으로 내림차순 정렬


    @Query(value = "select p from Post p left join PostTag pt where pt.hashTag.id = :id")
    List<Post> getPost(@Param("id") Long id);
}

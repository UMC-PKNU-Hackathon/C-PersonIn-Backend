package umc.coffeein.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.coffeein.domain.Comment;
import umc.coffeein.domain.Post;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}

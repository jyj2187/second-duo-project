package kr.rhinitis.secondduoproject.comment.repository;

import kr.rhinitis.secondduoproject.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}

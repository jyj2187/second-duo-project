package kr.rhinitis.secondduoproject.posts.repository;

import kr.rhinitis.secondduoproject.posts.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Posts, Long> {
}

package chaudnb.example.blogg.repository;

import chaudnb.example.blogg.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository  extends JpaRepository<Blog, Integer>
{
    List<Blog> findAllById(int id);

    @Query("SELECT b FROM Blog b WHERE (:q IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :q, '%')) OR LOWER(b.content) LIKE LOWER(CONCAT('%', :q, '%'))) AND (:categoryId IS NULL OR b.category.id = :categoryId)")
    Page<Blog> search(@Param("q") String q, @Param("categoryId") Integer categoryId, Pageable pageable);

}

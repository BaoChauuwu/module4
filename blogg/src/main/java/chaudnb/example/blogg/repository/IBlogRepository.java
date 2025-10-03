package chaudnb.example.blogg.repository;

import chaudnb.example.blogg.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository  extends JpaRepository<Blog, Integer>
{
    List<Blog> findAllById(int id);

}

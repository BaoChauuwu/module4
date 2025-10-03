package chaudnb.example.blogg.service;

import chaudnb.example.blogg.entity.Blog;
import chaudnb.example.blogg.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public boolean add(Blog blog) {
        return blogRepository.save(blog)!=null;
    }

    @Override
    public void deleteById(int id) {
        blogRepository.deleteById(id);
    }

}
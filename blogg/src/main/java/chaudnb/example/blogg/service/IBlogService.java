package chaudnb.example.blogg.service;

import chaudnb.example.blogg.entity.Blog;

public interface IBlogService {
    Iterable<Blog> findAll();

    Blog findById(int id);
    boolean add(Blog blog);
    void deleteById(int id);
}

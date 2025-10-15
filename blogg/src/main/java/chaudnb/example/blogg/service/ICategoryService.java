package chaudnb.example.blogg.service;

import chaudnb.example.blogg.entity.Category;

public interface ICategoryService {
    Iterable<Category> findAll();
    Category findById(int id);
    boolean save(Category category);
    void deleteById(int id);
}




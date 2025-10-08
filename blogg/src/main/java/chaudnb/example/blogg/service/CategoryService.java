package chaudnb.example.blogg.service;

import chaudnb.example.blogg.entity.Category;
import chaudnb.example.blogg.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(Category category) {
        return categoryRepository.save(category) != null;
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }
}



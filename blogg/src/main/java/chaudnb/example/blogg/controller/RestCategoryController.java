package chaudnb.example.blogg.controller;

import chaudnb.example.blogg.entity.Category;
import chaudnb.example.blogg.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/categories")

public class RestCategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categoryList=(List<Category>) categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Category> detailCategory(@PathVariable(name = "id") int id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);// 404
        }
        return new ResponseEntity<>(category, HttpStatus.OK);// 200
    }
}

package chaudnb.example.blogg.controller;

import chaudnb.example.blogg.entity.Blog;
import chaudnb.example.blogg.service.IBlogService;
import chaudnb.example.blogg.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String list(Model model,
                       @RequestParam(value = "q", required = false) String q,
                       @RequestParam(value = "categoryId", required = false) Integer categoryId,
                       @RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "size", defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        Page<Blog> blogPage = blogService.search(q, categoryId, pageable);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("q", q);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("categories", categoryService.findAll());
        return "blogs/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blogs/detail";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("action", "/blogs/create");
        model.addAttribute("categories", categoryService.findAll());
        return "blogs/form";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("blog") Blog blog, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "blogs/form";
        }
        blogService.add(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("action", "/blogs/edit/" + id);
        model.addAttribute("categories", categoryService.findAll());
        return "blogs/form";
    }

    @PostMapping("/edit/{id}")
    public String doEdit(@PathVariable("id") Integer id, @ModelAttribute("blog") Blog blog, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "blogs/form";
        }
        blog.setId(id);
        blogService.add(blog);
        return "redirect:/blogs";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        blogService.deleteById(id);
        return "redirect:/blogs";
    }
}




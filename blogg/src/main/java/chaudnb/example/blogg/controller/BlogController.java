package chaudnb.example.blogg.controller;

import chaudnb.example.blogg.entity.Blog;
import chaudnb.example.blogg.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("blogs", blogService.findAll());
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



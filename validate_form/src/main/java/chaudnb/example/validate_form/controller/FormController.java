package chaudnb.example.validate_form.controller;

import chaudnb.example.validate_form.dto.UserDTO;
import chaudnb.example.validate_form.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "index";
    }

    @PostMapping("/submit")
    public String submitForm(@Valid UserDTO user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        
        boolean success = userService.addUser(user);
        if (success) {
            model.addAttribute("user", user);
            return "result";
        } else {
            model.addAttribute("error", "Có lỗi xảy ra khi đăng ký");
            return "index";
        }
    }
}

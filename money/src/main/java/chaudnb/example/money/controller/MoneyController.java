package chaudnb.example.money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MoneyController {
    @GetMapping("/money")
    public String showFormChangeMoney(){
        return "showFormChangeMoney";
    }
    @PostMapping("/money")
    public String processChangeMoney(@ModelAttribute("money") double money, Model model){
        double tien = money*23000;
        model.addAttribute("tien",tien);
        return "showFormChangeMoney";
    }
}

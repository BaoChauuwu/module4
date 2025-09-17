package chaudnb.example.sanwich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandWichController {
    @GetMapping
    public String showForm(){
        return "index";
    }
    @PostMapping("/sandwich")
    public String showResult(@RequestParam (name = "condiment") String [] condiment, Model model){
        model.addAttribute("condiment", condiment);
        return "index";
    }
}

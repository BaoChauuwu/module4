package chaudnb.example.caculate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculateController {
    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/caculate")
    public String processForm(@RequestParam(name = "param1") int param1,
                              @RequestParam(name = "param2") int param2,
                              @RequestParam(name = "button") String button, Model model) {

        if (button != null) {
            switch (button) {
                case "Addition":
                    model.addAttribute("result", param1 + param2);
                    break;
                case "Subtraction":
                    model.addAttribute("result", param1 - param2);
                    break;
                case "Multiplication":
                    model.addAttribute("result", param1 * param2);
                    break;
                case "Division":
                    if (param2 == 0) {
                        model.addAttribute("mess", "Không thể chia cho 0!");
                        model.addAttribute("result", "Error");
                    } else {
                        model.addAttribute("result", (double) param1 / param2);
                    }
                    break;
                default:
                    break;


            }
        }
        return "index";
    }
}

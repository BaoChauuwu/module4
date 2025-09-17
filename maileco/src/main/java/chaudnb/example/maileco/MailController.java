package chaudnb.example.maileco;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MailController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("mail", new Mail());
        return "index";

    }
    @PostMapping("/save")
    public String saveMail(@ModelAttribute (name = "mail") Mail mail, RedirectAttributes redirectAttributes) {
        if (mail.getLanguage() == null || mail.getLanguage().trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Please select a language");
            return "redirect:/";
        }
        
        if (mail.getSize() <= 0) {
            redirectAttributes.addFlashAttribute("error", "Please select a valid page size");
            return "redirect:/";
        }
        
        redirectAttributes.addFlashAttribute("success", "Settings updated successfully!");
        return "redirect:/";
    }

}

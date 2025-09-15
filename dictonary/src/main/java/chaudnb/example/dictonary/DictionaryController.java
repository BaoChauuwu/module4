package chaudnb.example.dictonary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("dog", "con chó");
        dictionary.put("cat", "con mèo");
        dictionary.put("computer", "máy tính");
        dictionary.put("school", "trường học");
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam("word") String word, Model model) {
        String meaning = dictionary.get(word.toLowerCase());
        if (meaning != null) {
            model.addAttribute("result", "Nghĩa của \"" + word + "\" là: " + meaning);
        } else {
            model.addAttribute("result", "Không tìm thấy từ: " + word);
        }
        return "index";
    }
}

package chaudnb.example.aop.controller;

import chaudnb.example.aop.model.BorrowRecord;
import chaudnb.example.aop.service.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/borrow")
@RequiredArgsConstructor
public class BorrowController {
    
    private final BorrowService borrowService;
    
    @PostMapping("/{bookId}")
    public String borrowBook(@PathVariable Long bookId, 
                           @RequestParam String borrowerName,
                           RedirectAttributes redirectAttributes) {
        try {
            BorrowRecord borrowRecord = borrowService.borrowBook(bookId, borrowerName);
            redirectAttributes.addFlashAttribute("success", 
                    "Book borrowed successfully! Your borrow code is: " + borrowRecord.getBorrowCode());
            return "redirect:/books/" + bookId;
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/books/" + bookId;
        }
    }
    
    @GetMapping("/return")
    public String showReturnForm(Model model) {
        return "borrow/return";
    }
    
    @PostMapping("/return")
    public String returnBook(@RequestParam String borrowCode, RedirectAttributes redirectAttributes) {
        try {
            borrowService.returnBook(borrowCode);
            redirectAttributes.addFlashAttribute("success", "Book returned successfully!");
            return "redirect:/borrow/return";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/borrow/return";
        }
    }
    
    @GetMapping("/records")
    public String getAllBorrowRecords(Model model) {
        List<BorrowRecord> records = borrowService.getAllBorrowRecords();
        model.addAttribute("records", records);
        return "borrow/records";
    }
    
    @GetMapping("/active")
    public String getActiveBorrowRecords(Model model) {
        List<BorrowRecord> records = borrowService.getActiveBorrowRecords();
        model.addAttribute("records", records);
        return "borrow/active";
    }
}

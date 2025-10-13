package chaudnb.example.aop.controller;

import chaudnb.example.aop.model.Book;
import chaudnb.example.aop.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    
    private final BookService bookService;
    
    @GetMapping
    public String getAllBooks(Model model, @RequestParam(required = false) String search) {
        List<Book> books;
        if (search != null && !search.trim().isEmpty()) {
            books = bookService.searchBooks(search);
        } else {
            books = bookService.getAllBooks();
        }
        model.addAttribute("books", books);
        model.addAttribute("search", search);
        return "books/list";
    }
    
    @GetMapping("/available")
    public String getAvailableBooks(Model model) {
        List<Book> books = bookService.getAvailableBooks();
        model.addAttribute("books", books);
        return "books/available";
    }
    
    @GetMapping("/{id}")
    public String getBookDetail(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "books/detail";
        } else {
            redirectAttributes.addFlashAttribute("error", "Book not found");
            return "redirect:/books";
        }
    }
    
    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/add";
    }
    
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        try {
            bookService.saveBook(book);
            redirectAttributes.addFlashAttribute("success", "Book added successfully!");
            return "redirect:/books";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to add book: " + e.getMessage());
            return "redirect:/books/add";
        }
    }
}

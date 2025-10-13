package chaudnb.example.aop.service;

import chaudnb.example.aop.model.Book;
import chaudnb.example.aop.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    
    private final BookRepository bookRepository;
    
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    public List<Book> getAvailableBooks() {
        return bookRepository.findAvailableBooks();
    }
    
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }
    
    public List<Book> searchBooks(String keyword) {
        return bookRepository.searchBooks(keyword);
    }
    
    @Transactional
    public Book saveBook(Book book) {
        log.info("Saving new book: {}", book.getTitle());
        return bookRepository.save(book);
    }
    
    @Transactional
    public void decreaseAvailableQuantity(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));
        
        if (book.getAvailableQuantity() <= 0) {
            throw new RuntimeException("No books available for borrowing");
        }
        
        book.setAvailableQuantity(book.getAvailableQuantity() - 1);
        bookRepository.save(book);
        log.info("Decreased available quantity for book '{}' to {}", 
                book.getTitle(), book.getAvailableQuantity());
    }
    
    @Transactional
    public void increaseAvailableQuantity(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));
        
        if (book.getAvailableQuantity() >= book.getTotalQuantity()) {
            throw new RuntimeException("Cannot return more books than total quantity");
        }
        
        book.setAvailableQuantity(book.getAvailableQuantity() + 1);
        bookRepository.save(book);
        log.info("Increased available quantity for book '{}' to {}", 
                book.getTitle(), book.getAvailableQuantity());
    }
}

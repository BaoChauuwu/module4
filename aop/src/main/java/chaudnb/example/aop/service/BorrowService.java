package chaudnb.example.aop.service;

import chaudnb.example.aop.model.Book;
import chaudnb.example.aop.model.BorrowRecord;
import chaudnb.example.aop.repository.BorrowRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class BorrowService {
    
    private final BorrowRecordRepository borrowRecordRepository;
    private final BookService bookService;
    private final Random random = new Random();
    
    @Transactional
    public BorrowRecord borrowBook(Long bookId, String borrowerName) {
        // Kiểm tra sách có tồn tại và có thể mượn
        Book book = bookService.getBookById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));
        
        if (book.getAvailableQuantity() <= 0) {
            throw new RuntimeException("No books available for borrowing");
        }
        
        // Tạo mã mượn sách ngẫu nhiên 5 chữ số
        String borrowCode = generateBorrowCode();
        
        // Tạo bản ghi mượn sách
        BorrowRecord borrowRecord = new BorrowRecord(borrowCode, book, borrowerName);
        borrowRecord = borrowRecordRepository.save(borrowRecord);
        
        // Giảm số lượng sách có sẵn
        bookService.decreaseAvailableQuantity(bookId);
        
        log.info("Book '{}' borrowed successfully with code: {}", book.getTitle(), borrowCode);
        return borrowRecord;
    }
    
    @Transactional
    public void returnBook(String borrowCode) {
        BorrowRecord borrowRecord = borrowRecordRepository.findByBorrowCode(borrowCode)
                .orElseThrow(() -> new RuntimeException("Invalid borrow code: " + borrowCode));
        
        if (borrowRecord.getStatus() == BorrowRecord.BorrowStatus.RETURNED) {
            throw new RuntimeException("Book has already been returned");
        }
        
        // Cập nhật trạng thái trả sách
        borrowRecord.setStatus(BorrowRecord.BorrowStatus.RETURNED);
        borrowRecord.setReturnDate(LocalDateTime.now());
        borrowRecordRepository.save(borrowRecord);
        
        // Tăng số lượng sách có sẵn
        bookService.increaseAvailableQuantity(borrowRecord.getBook().getId());
        
        log.info("Book '{}' returned successfully with code: {}", 
                borrowRecord.getBook().getTitle(), borrowCode);
    }
    
    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordRepository.findAll();
    }
    
    public List<BorrowRecord> getBorrowRecordsByBorrower(String borrowerName) {
        return borrowRecordRepository.findByBorrowerName(borrowerName);
    }
    
    public List<BorrowRecord> getActiveBorrowRecords() {
        return borrowRecordRepository.findByStatus(BorrowRecord.BorrowStatus.BORROWED);
    }
    
    private String generateBorrowCode() {
        return String.format("%05d", random.nextInt(100000));
    }
}

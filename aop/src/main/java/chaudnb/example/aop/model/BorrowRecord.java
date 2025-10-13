package chaudnb.example.aop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "borrow_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowRecord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String borrowCode;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
    
    @Column(nullable = false)
    private String borrowerName;
    
    @Column(nullable = false)
    private LocalDateTime borrowDate;
    
    private LocalDateTime returnDate;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BorrowStatus status;
    
    public enum BorrowStatus {
        BORROWED, RETURNED
    }
    
    public BorrowRecord(String borrowCode, Book book, String borrowerName) {
        this.borrowCode = borrowCode;
        this.book = book;
        this.borrowerName = borrowerName;
        this.borrowDate = LocalDateTime.now();
        this.status = BorrowStatus.BORROWED;
    }
}


package chaudnb.example.aop.repository;

import chaudnb.example.aop.model.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
    
    Optional<BorrowRecord> findByBorrowCode(String borrowCode);
    
    List<BorrowRecord> findByBorrowerName(String borrowerName);
    
    List<BorrowRecord> findByBookId(Long bookId);
    
    List<BorrowRecord> findByStatus(BorrowRecord.BorrowStatus status);
}


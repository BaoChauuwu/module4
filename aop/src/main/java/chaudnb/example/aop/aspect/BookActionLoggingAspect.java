package chaudnb.example.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookActionLoggingAspect {
    
    @After("execution(* chaudnb.example.aop.service.BookService.decreaseAvailableQuantity(..))")
    public void logBookBorrowed() {
        System.out.println("Đã ghi log: Sách đã được mượn - số lượng giảm xuống 1");
    }
    
    @After("execution(* chaudnb.example.aop.service.BookService.increaseAvailableQuantity(..))")
    public void logBookReturned() {
        System.out.println("Đã ghi log: Sách đã được trả - số lượng tăng lên 1");
    }
    
    @After("execution(* chaudnb.example.aop.service.BookService.saveBook(..))")
    public void logBookAdded() {
        System.out.println("Đã ghi log: Sách mới đã được thêm vào thư viện");
    }
}

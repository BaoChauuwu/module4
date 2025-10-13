package chaudnb.example.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class VisitorCountLoggingAspect {
    
    private static int visitorCount = 0;
    
    @After("execution(* chaudnb.example.aop.controller.BookController.getAllBooks(..))")
    public void countViewAllBooks() {
        visitorCount++;
        System.out.println("Số lượng người ghé thăm thư viện hiện tại: " + visitorCount);
    }
    
    @After("execution(* chaudnb.example.aop.controller.BookController.getAvailableBooks(..))")
    public void countViewAvailableBooks() {
        visitorCount++;
        System.out.println("Số lượng người ghé thăm thư viện hiện tại: " + visitorCount);
    }

    
    @After("execution(* chaudnb.example.aop.controller.BookController.getBookDetail(..))")
    public void countViewBookDetail() {
        visitorCount++;
        System.out.println("Số lượng người ghé thăm thư viện hiện tại: " + visitorCount);
    }
    
    @After("execution(* chaudnb.example.aop.controller.BorrowController.showReturnForm(..))")
    public void countViewReturnForm() {
        visitorCount++;
        System.out.println("Số lượng người ghé thăm thư viện hiện tại: " + visitorCount);
    }
}

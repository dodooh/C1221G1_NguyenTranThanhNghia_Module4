package com.example.ung_dung_muon_sach.logger;


import com.example.ung_dung_muon_sach.exception.NotFoundException;
import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.RentCode;
import com.example.ung_dung_muon_sach.service.IBookService;
import com.example.ung_dung_muon_sach.service.IRentCodeService;
import com.example.ung_dung_muon_sach.utils.WriteLog;
import java.time.LocalDate;
import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

    private String rentLog = "./src/main/resources/log/rent.log";
    private String bookLog = "./src/main/resources/log/book.log";

    @Autowired
    private IBookService iBookService;
    @Autowired
    private IRentCodeService iRentCodeService;

    @AfterReturning("execution(* com.example.ung_dung_muon_sach.controller.BookController.*Book(..))")
    public void afterRentSuccess(JoinPoint joinpoint) throws NotFoundException {
        String methods = joinpoint.getSignature().getName();
        if (methods.equals("rentBook")) {
            Object[] signatureArgs = joinpoint.getArgs();
            Long id = (Long) signatureArgs[0];
            Book book = iBookService.findById(id);
            String log = "[" + new Date() + "] [SUCCESS] [RENT] Book: " + book.getName();
            WriteLog.write(rentLog, log);
        } else {
            Object[] signatureArgs = joinpoint.getArgs();
            Long id = (Long) signatureArgs[0];
            Book book = iBookService.findById(id);
            String log = "[" + new Date() + "] [SUCCESS] [RETURN] Book: " + book.getName();
            WriteLog.write(rentLog, log);
        }
    }

    @AfterReturning("execution(* com.example.ung_dung_muon_sach.controller.BookController.create(..))")
    public void afterReturningCreateBook(JoinPoint joinpoint) {
        Object[] signatureArgs = joinpoint.getArgs();
        Book book = (Book) signatureArgs[0];
        String log = "[" + new Date() + "] [SUCCESS] [CREATE] Book: " + book.getName();
        WriteLog.write(bookLog, log);
    }

    @AfterReturning("execution(* com.example.ung_dung_muon_sach.controller.BookController.goView(..))")
    public void afterReturningViewBook(JoinPoint joinpoint) throws NotFoundException {
        Object[] signatureArgs = joinpoint.getArgs();
        Long id = (Long) signatureArgs[0];
        Book book = iBookService.findById(id);
        String log = "[" + new Date() + "] [SUCCESS] [VIEW] Book: " + book.getName();
        WriteLog.write(bookLog, log);
    }


}

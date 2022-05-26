package com.example.ung_dung_muon_sach.controller;


import com.example.ung_dung_muon_sach.exception.NotFoundException;
import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.RentCode;
import com.example.ung_dung_muon_sach.service.IBookService;
import com.example.ung_dung_muon_sach.service.IRentCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    private IBookService iBookService;

    @Autowired
    private IRentCodeService iRentCodeService;

    @GetMapping("")
    public String goHome(Model model) {
        model.addAttribute("books", iBookService.findAll());
        return "index";
    }

    @GetMapping("create")
    public String goCreate(Model model) {
        model.addAttribute("book", new Book());
        return "create";
    }

    @GetMapping("view/{id}")
    public String goView(@PathVariable("id") Long id, Model model) throws NotFoundException {
        Book book = iBookService.findById(id);
        model.addAttribute("book", book);
        return "view";
    }

    @PostMapping("create")
    public String create(@ModelAttribute("book") Book book) {
        iBookService.save(book);
        return "redirect:";
    }

    @GetMapping("rent/{id}")
    public String rentBook(@PathVariable("id") Long id, RedirectAttributes ra) throws NotFoundException {
        if (iBookService.isAvailable(id)) {
            Book book = iBookService.findById(id);
            iBookService.rent(book);
            ra.addFlashAttribute("rentCode", "Rent Code: " + iRentCodeService.save(new RentCode(book)));
            return "redirect:/view/" + id;
        }
        ra.addFlashAttribute("err", "Not Available");
        return "redirect:/view/" + id;
    }
    @GetMapping("turnback")
    public String turnbackBook(@RequestParam("bookId") Long id,
        @RequestParam("rentCode") Long rentCode,
        RedirectAttributes ra) {

        if (iRentCodeService.findById(rentCode) != null) {
            RentCode rentCode1 = iRentCodeService.findById(rentCode);
            Book book = rentCode1.getBook();
            iBookService.turnback(book);
            iRentCodeService.delete(rentCode1);
            ra.addFlashAttribute("rentCode", "Return Success");
            return "redirect:/view/" + book.getId();
        }
        ra.addFlashAttribute("err", "Not Found Rent Code");
        return "redirect:/view/" + id;
    }

    @ExceptionHandler(NotFoundException.class)
    public String notFound() {
        return "error";
    }

}

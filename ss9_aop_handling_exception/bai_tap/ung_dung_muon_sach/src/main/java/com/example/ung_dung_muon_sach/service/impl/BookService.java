package com.example.ung_dung_muon_sach.service.impl;

import com.example.ung_dung_muon_sach.exception.NotFoundException;
import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.repository.IBookRepository;
import com.example.ung_dung_muon_sach.service.IBookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public boolean isAvailable(Long id) throws NotFoundException {
        Book book = this.findById(id);
        return book != null && book.getQuantity() > 0;
    }

    @Override
    public Book findById(Long id) throws NotFoundException {
        Book book = iBookRepository.findById(id).orElse(null);
        if (book != null) {
            return book;
        } else {
            throw new NotFoundException("Not Found Book With Id " + id);
        }
    }

    @Override
    public void rent(Book book) {
        book.setQuantity(book.getQuantity() - 1);
        iBookRepository.save(book);
    }

    @Override
    public void turnback(Book book) {
        book.setQuantity(book.getQuantity() + 1);
        iBookRepository.save(book);
    }


}

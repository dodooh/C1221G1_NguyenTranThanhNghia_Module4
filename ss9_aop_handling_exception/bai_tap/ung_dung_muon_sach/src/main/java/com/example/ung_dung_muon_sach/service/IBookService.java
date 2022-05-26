package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.exception.NotFoundException;
import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.RentCode;
import java.util.List;

public interface IBookService {

    List<Book> findAll();

    void save(Book book);

    boolean isAvailable(Long id) throws NotFoundException;

    Book findById(Long id) throws NotFoundException;

    void rent(Book book);

    void turnback(Book book);
}

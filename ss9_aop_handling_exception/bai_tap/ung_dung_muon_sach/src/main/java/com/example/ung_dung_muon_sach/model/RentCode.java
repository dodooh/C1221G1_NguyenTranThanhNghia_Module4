package com.example.ung_dung_muon_sach.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "rent_code")
@EntityListeners(AuditingEntityListener.class)
public class RentCode {
    @Id
    @GenericGenerator(name = "random_5_number_id", strategy = "com.example.ung_dung_muon_sach.utils.MyGenerator")
    @GeneratedValue(generator = "random_5_number_id")
    private Long code;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Book book;

    @CreatedDate
    private Date dateRent;

    public RentCode(Book book) {
        this.book = book;
    }

    public RentCode() {
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDateRent() {
        return dateRent;
    }

    public void setDateRent(Date dateRent) {
        this.dateRent = dateRent;
    }
}
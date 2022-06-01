package com.codegym.dto;

import com.codegym.model.Product;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class OrderDetailDto implements Validator {

    private Long id;
    private String purchaseDate;
    private Integer quantity;
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderDetailDto() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrderDetailDto orderDetailDto = (OrderDetailDto) target;

        String dateCheck = orderDetailDto.getPurchaseDate();

//        String DATE_REGEX = "^\\d{2}/\\d{2}/\\d{4}$";
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        fmt.setLenient(false);
        Date date = null;
        try {
            date = fmt.parse(dateCheck);
            // KIEM TRA NGAY CO TRONG QUA KHU KHONG
            if (date != null && date.compareTo(new Date()) <= 0) {
                errors.rejectValue("purchaseDate", "date.future");
            }
        } catch (ParseException e) {
            e.printStackTrace();
            errors.rejectValue("purchaseDate", "date.valid");
        }

        Integer quantityCheck = orderDetailDto.getQuantity();
        if (quantityCheck == null) {
            errors.rejectValue("quantity", "typeMismatch.quantity");
        } else if (quantityCheck <= 0) {
            errors.rejectValue("quantity", "quantity.positive");

        }

    }
}

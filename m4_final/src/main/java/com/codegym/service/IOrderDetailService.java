package com.codegym.service;

import com.codegym.model.OrderDetail;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderDetailService {

    Page<OrderDetail> findAll(Pageable pageable);

    List<OrderDetail> findTop(Integer limit);
    Optional<OrderDetail> findById(Long id);

    boolean isValidDate(String fromDate, String toDate);

    Page<OrderDetail>  findAll(String fromDate, String toDate, Pageable pageable);

    void save(OrderDetail orderDetail);

}

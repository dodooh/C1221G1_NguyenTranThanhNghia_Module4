package com.codegym.service.impl;

import com.codegym.model.OrderDetail;
import com.codegym.repository.IOrderDetailRepository;
import com.codegym.service.IOrderDetailService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    private IOrderDetailRepository orderDetailRepository;

    @Override
    public Page<OrderDetail> findAll(Pageable pageable) {
        return orderDetailRepository.findAll(pageable);
    }

    @Override
    public List<OrderDetail> findTop(Integer limit) {
        return orderDetailRepository.findTop(limit);
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return orderDetailRepository.findById(id);
    }

    @Override
    public boolean isValidDate(String fromDate, String toDate) {
        if (!"".equals(fromDate) && !"".equals(toDate)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            try {
                Date from = sdf.parse(fromDate);
                Date to = sdf.parse(toDate);
                if (from.compareTo(to) > 0) {
                    return false;
                }
            } catch (ParseException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Override
    public Page<OrderDetail> findAll(String fromDate, String toDate, Pageable pageable) {
        if ("".equals(fromDate) && "".equals(toDate)) {
            return orderDetailRepository.findAll(pageable);
        } else if ("".equals(fromDate)) {
            return orderDetailRepository.findAllByPurchaseDateBefore(toDate, pageable);
        } else if ("".equals(toDate)) {
            return orderDetailRepository.findAllByPurchaseDateAfter(fromDate, pageable);
        }
        return orderDetailRepository.findAllByPurchaseDateAfterAndPurchaseDateBefore(fromDate, toDate, pageable);
    }

    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }
}

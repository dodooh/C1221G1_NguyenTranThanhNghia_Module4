package com.codegym.repository;

import com.codegym.model.OrderDetail;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    @Query(value="select od.id, purchase_date, quantity, od.product_id, (od.quantity * p.price) as total\n"
        + "from order_detail od join product p on p.id = od.product_id\n" + "group by od.id\n" + "order by total desc\n"
        + " limit :limit", nativeQuery = true)
    List<OrderDetail> findTop(@Param("limit") Integer limit);

    Page<OrderDetail> findAllByPurchaseDateAfter(String fromDate, Pageable pageable);

    Page<OrderDetail> findAllByPurchaseDateBefore(String toDate, Pageable pageable);
    Page<OrderDetail> findAllByPurchaseDateAfterAndPurchaseDateBefore(String fromDate,String toDate, Pageable pageable);
}

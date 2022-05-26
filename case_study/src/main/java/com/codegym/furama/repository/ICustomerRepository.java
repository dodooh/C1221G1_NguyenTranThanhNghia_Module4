package com.codegym.furama.repository;

import com.codegym.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICustomerRepository extends JpaRepository<Customer, String> {

    Page<Customer> findAllByNameContainingAndIsActivated(String name,Boolean isActivated, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update m4_furama.customer e set e.is_activated = false where e.id = :customer_id", nativeQuery = true)
    Integer deactivate(@Param("customer_id") String id);



}

package com.example.ung_dung_muon_sach.repository;

import com.example.ung_dung_muon_sach.model.RentCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentCodeRepository extends JpaRepository<RentCode, Long> {

    RentCode findFirstByOrderByDateRentDesc();
}

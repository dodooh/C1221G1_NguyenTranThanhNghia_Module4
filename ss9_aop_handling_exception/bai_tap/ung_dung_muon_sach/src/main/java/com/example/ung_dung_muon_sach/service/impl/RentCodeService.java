package com.example.ung_dung_muon_sach.service.impl;

import com.example.ung_dung_muon_sach.model.RentCode;
import com.example.ung_dung_muon_sach.repository.IRentCodeRepository;
import com.example.ung_dung_muon_sach.service.IRentCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentCodeService implements IRentCodeService {

    @Autowired
    private IRentCodeRepository iRentCodeRepository;

    @Override
    public Long save(RentCode rentCode) {
        iRentCodeRepository.save(rentCode);
        return iRentCodeRepository.findFirstByOrderByDateRentDesc().getCode();
    }

    @Override
    public RentCode findById(Long rentCode) {
        return iRentCodeRepository.findById(rentCode).orElse(null);
    }

    @Override
    public void delete(RentCode rentCode1) {
        iRentCodeRepository.delete(rentCode1);
    }
}

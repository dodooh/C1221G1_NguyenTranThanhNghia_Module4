package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.RentCode;

public interface IRentCodeService {

    Long save(RentCode rentCode);

    RentCode findById(Long rentCode);

    void delete(RentCode rentCode1);
}

package com.codegym.service.impl;

import com.codegym.model.Setting;
import com.codegym.repository.ISettingRepository;
import com.codegym.service.ISettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingServiceImpl implements ISettingService {

    @Autowired
    private ISettingRepository iSettingRepository;

    @Override
    public void save(Setting setting) {
        iSettingRepository.save(setting);
    }

    @Override
    public Setting get() {
        return iSettingRepository.get();
    }
}

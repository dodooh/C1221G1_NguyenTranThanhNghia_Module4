package com.codegym.repository.impl;

import com.codegym.model.Setting;
import com.codegym.repository.ISettingRepository;
import org.springframework.stereotype.Repository;


@Repository
public class SettingRepositoryImpl implements ISettingRepository {

    private Setting userSetting = new Setting();

    @Override
    public void save(Setting setting) {
        userSetting = new Setting(setting);
    }

    @Override
    public Setting get() {
        return userSetting;
    }
}

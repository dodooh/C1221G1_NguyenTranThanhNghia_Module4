package com.codegym.service;

import com.codegym.model.Setting;

public interface ISettingService {
    void save(Setting setting);

    Setting get();
}

package com.codegym.repository;

import com.codegym.model.Setting;

public interface ISettingRepository {
    void save(Setting setting);

    Setting get();
}

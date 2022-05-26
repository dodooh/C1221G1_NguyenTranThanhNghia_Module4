package com.codegym.repository;

import com.codegym.model.Music;
import java.util.List;

public interface IMusicRepository {

    List<Music> findAll();

    void save(Music music);
}

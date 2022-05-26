package com.codegym.validate_thong_tin_bai_hat.service;

import com.codegym.validate_thong_tin_bai_hat.model.Song;
import java.util.List;

public interface ISongService {

    void save(Song song);

    List<Song> findAll();
}

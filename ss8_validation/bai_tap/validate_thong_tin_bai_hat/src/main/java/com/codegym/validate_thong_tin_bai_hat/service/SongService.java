package com.codegym.validate_thong_tin_bai_hat.service;

import com.codegym.validate_thong_tin_bai_hat.model.Song;
import com.codegym.validate_thong_tin_bai_hat.repository.ISongRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService{

    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public List<Song> findAll() {
        return iSongRepository.findAll();
    }
}

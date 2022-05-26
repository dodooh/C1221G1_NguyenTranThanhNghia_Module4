package com.codegym.service.impl;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import com.codegym.service.ISongService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    private ISongRepository iMusicRepository;

    @Override
    public List<Song> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public void save(Song song) {
        iMusicRepository.save(song);
    }

    @Override
    public Song findById(Long id) {
        return iMusicRepository.findById(id);
    }

    @Override
    public void remove(Long songId) {
        iMusicRepository.remove(songId);
    }
}

package com.codegym.repository.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository
public class MusicRepositoryImpl implements IMusicRepository {
    private static List<Music> musicList = new ArrayList<>();

    static {
        musicList.add(new Music("Bai Hat A", "Ca Si A", "Rap", "sep.mp3"));
        musicList.add(new Music("Bai Hat B", "Ca Si B", "Hiphop", "sep.mp3"));
        musicList.add(new Music("Bai Hat C", "Ca Si C", "Rap", "sep.mp3"));
        musicList.add(new Music("Bai Hat R", "Ca Si R", "Rap", "sep.mp3"));
    }

    @Override
    public List<Music> findAll() {
        return musicList;
    }

    @Override
    public void save(Music music) {
        musicList.add(music);
    }
}

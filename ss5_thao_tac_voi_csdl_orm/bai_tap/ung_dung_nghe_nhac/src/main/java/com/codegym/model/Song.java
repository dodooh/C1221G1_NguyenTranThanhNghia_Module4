package com.codegym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;

    private String name;
    private String artist;
    private String genre;
    private String pathFile;

    public Song(String name, String artist, String genre, String pathFile) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.pathFile = pathFile;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public Song(Long songId, String name, String artist, String genre, String pathFile) {
        this.songId = songId;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.pathFile = pathFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public Song() {
    }

    public Long getSongId() {
        return songId;
    }
//    @Override
//    public Song clone() {
//        Song song = new Song();
//        song.setSongId(songId);
//        song.setName(name);
//        song.setArtist(artist);
//        song.setGenre(genre);
//        song.setPathFile(pathFile);
//        return song;
//    }

    @Override
    public String toString() {
        return "Song{" +
            "id=" + songId +
            ", name='" + name + '\'' +
            ", artist='" + artist + '\'' +
            ", genre='" + genre + '\'' +
            ", pathFile='" + pathFile + '\'' +
            '}';
    }
}

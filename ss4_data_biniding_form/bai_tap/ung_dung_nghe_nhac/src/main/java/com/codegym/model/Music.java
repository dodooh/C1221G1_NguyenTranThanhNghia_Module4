package com.codegym.model;

public class Music {
    private String name;
    private String artist;
    private String genre;
    private String pathFile;

    public Music() {
    }

    public Music(String name, String artist, String genre, String pathFile) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.pathFile = pathFile;
    }

    @Override
    public String toString() {
        return "Music{" +
            "name='" + name + '\'' +
            ", artist='" + artist + '\'' +
            ", genre='" + genre + '\'' +
            ", pathFile='" + pathFile + '\'' +
            '}';
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
}

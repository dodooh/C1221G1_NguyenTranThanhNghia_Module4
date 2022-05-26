package com.codegym.validate_thong_tin_bai_hat.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class SongDto{

    private Long Id;


    @NotBlank(message = "Song {name.notBlank}")
    @Size(max = 800, message = "{name.limitCharacter800}")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "{name.mistype}")
    private String name;

    @NotBlank(message = "Artist {name.notBlank}")
    @Size(max = 300, message = "{artist.limitCharacter300}")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "{artist.mistype}")
    private String artist;

    @NotBlank(message = "Genre {name.notBlank}")
    @Size(max = 1000, message = "{genre.limitCharacter1000}")
    @Pattern(regexp = "^[,a-zA-Z]+$", message = "{genre.mistype}")

    private String genre;

    public SongDto() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

}

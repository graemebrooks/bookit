package com.bookit.bookit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Book {

    private final UUID id;

    @NotBlank(message = "Title cannot be left blank")
    private final String title;

    private final String author;

    private final String genre;

    public Book(@JsonProperty("id") UUID id,
                @JsonProperty("title") String title,
                @JsonProperty("author") String author,
                @JsonProperty("genre") String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }
}

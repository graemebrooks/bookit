package com.bookit.bookit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Book {

    private final UUID id;
    private final String title;

    public Book(@JsonProperty("id") UUID id,
                @JsonProperty("title") String title) {
        this.id = id;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}

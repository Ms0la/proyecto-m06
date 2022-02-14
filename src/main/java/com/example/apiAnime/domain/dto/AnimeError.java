package com.example.apiAnime.domain.dto;

public class AnimeError {
    public String message;

    public static AnimeError message(String message) {
        AnimeError error = new AnimeError();
        error.message = message;
        return error;
    }
}

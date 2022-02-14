package com.example.apiAnime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface GenreProjection {
    UUID getGenreid();
    String getLabel();
    @JsonIgnoreProperties("genres")
    Set<AnimeProjection> getAnimes();
}
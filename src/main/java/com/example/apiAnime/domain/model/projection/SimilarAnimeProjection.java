package com.example.apiAnime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface SimilarAnimeProjection {
    UUID getAnimeid();
    String getName();
    String getDescription();
    String getImageurl();
    @JsonIgnoreProperties("animes")
    Set<GenreProjection> getGenres();
}

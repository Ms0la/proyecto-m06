package com.example.apiAnime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface AnimeProjection {

    UUID getAnimeid();
    String getName();

    String getDescription();
    String getType();
    int getYear();
    String getImageurl();

    @JsonIgnoreProperties("animes")
    Set<AuthorProjection> getAuthors();

    @JsonIgnoreProperties("animes")
    Set<GenreProjection> getGenres();

    Set<SimilarAnimeProjection> getRecomendations();
}

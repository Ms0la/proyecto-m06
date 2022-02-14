package com.example.apiAnime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface AuthorProjection {
    UUID getAuthorid();
    String getName();
    String getImageurl();
    @JsonIgnoreProperties("authors")
    Set<AnimeProjection> getAnimes();
}

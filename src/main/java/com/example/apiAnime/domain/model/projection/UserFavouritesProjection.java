package com.example.apiAnime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

public interface UserFavouritesProjection {
    @JsonIgnoreProperties("favoritedby")
    Set<AnimeFavouritedProjection> getFavorites();
}

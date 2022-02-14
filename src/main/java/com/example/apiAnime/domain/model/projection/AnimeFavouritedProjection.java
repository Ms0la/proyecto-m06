package com.example.apiAnime.domain.model.projection;

import java.util.UUID;

public interface AnimeFavouritedProjection {
    UUID getAnimeid();
    String getName();
    String getImageurl();
}

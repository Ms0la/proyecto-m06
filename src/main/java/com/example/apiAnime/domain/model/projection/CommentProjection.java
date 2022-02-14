package com.example.apiAnime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

public interface CommentProjection {
    UUID getAnimeid();
    UUID getUserid();

    @JsonIgnoreProperties("comments")
    String getComment();
}

package com.example.apiAnime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface CommentsAnimeProjection {

    UUID getAnimeid();
    String getName();

    @JsonIgnoreProperties("comments")
    Set<CommentProjection> getComments();
}

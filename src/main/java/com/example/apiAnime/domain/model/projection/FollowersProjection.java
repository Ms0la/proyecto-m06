package com.example.apiAnime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface FollowersProjection {
    UUID getUserid();
    String getUsername();

    @JsonIgnoreProperties("followers")
    Set<UserProjection> getFollowers();
}

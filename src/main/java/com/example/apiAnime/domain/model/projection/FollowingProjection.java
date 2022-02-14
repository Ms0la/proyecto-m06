package com.example.apiAnime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface FollowingProjection {
    UUID getUserid();
    String getUsername();

    @JsonIgnoreProperties("following")
    Set<UserProjection> getFollowing();
}

package com.example.apiAnime.domain.model.projection;

import com.example.apiAnime.domain.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface UserProjection {
    UUID getUserid();
    String getUsername();
    String getPassword();

}

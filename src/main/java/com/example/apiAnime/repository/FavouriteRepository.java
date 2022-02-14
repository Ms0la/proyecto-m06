package com.example.apiAnime.repository;


import com.example.apiAnime.domain.model.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FavouriteRepository extends JpaRepository<Favourite, UUID> {
    Favourite findByAnimeid(UUID id);
}

package com.example.apiAnime.repository;


import com.example.apiAnime.domain.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GenreRepository extends JpaRepository<Genre, UUID> {
    Genre findByLabel(String label);
    <T> List<T> findBy(Class<T> type);
}

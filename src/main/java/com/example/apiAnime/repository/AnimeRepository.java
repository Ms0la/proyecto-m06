package com.example.apiAnime.repository;

import com.example.apiAnime.domain.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.apiAnime.domain.model.projection.AnimeProjection;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import javax.swing.*;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface AnimeRepository extends JpaRepository<Anime, UUID> {
    Anime findByName(String name);

    <T> List<T> findBy(Class<T> type);
    <T> List<T> findByAnimeid(UUID id, Class<T> type);
    <T> List<T> findByName(String name, Class<T> type);

    @Query("SELECT a FROM Anime a WHERE lower(a.name) LIKE %?1%")
    <T> List<T> search(String keyword, Class<T> type);

}

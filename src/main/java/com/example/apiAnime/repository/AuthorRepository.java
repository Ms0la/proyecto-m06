package com.example.apiAnime.repository;

import com.example.apiAnime.domain.model.Author;
import com.example.apiAnime.domain.model.projection.AuthorProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
    Author findByName(String name);
    <T> List<T> findBy(Class<T> type);

    @Query("SELECT a FROM Author a WHERE lower(a.name) LIKE %?1%")
    <T> List<T> search(String keyword, Class<T> type);
}
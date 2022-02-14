package com.example.apiAnime.repository;

import com.example.apiAnime.domain.model.User;
import com.example.apiAnime.domain.model.projection.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUsername(String username);

    void deleteById(UUID id);

    <T> List<T> findByUsername(String username, Class<T> type);

    List<UserProjection> findBy();

    @Query("SELECT u FROM User u WHERE lower(u.username) LIKE %?1%")
    <T> List<T> search(String keyword, Class<T> type);

}


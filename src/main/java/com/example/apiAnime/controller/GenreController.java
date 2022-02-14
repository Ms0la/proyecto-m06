package com.example.apiAnime.controller;

import com.example.apiAnime.domain.dto.AnimeError;
import com.example.apiAnime.domain.model.Author;
import com.example.apiAnime.domain.model.Genre;
import com.example.apiAnime.domain.model.projection.AuthorProjection;
import com.example.apiAnime.domain.model.projection.GenreProjection;
import com.example.apiAnime.repository.AuthorRepository;
import com.example.apiAnime.repository.GenreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/genres")
public class GenreController {
    private final GenreRepository genreRepository;
    GenreController(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    @GetMapping("/")
    public ResponseEntity<?> findAllGenres(){
        return ResponseEntity.ok().body(genreRepository.findBy(GenreProjection.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGenre(@PathVariable UUID id){
        Genre genre = genreRepository.findById(id).orElse(null);

        if(genre==null) return
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(AnimeError.message("No s'ha trobat el genere amb id: '" + id + "'"));
        return ResponseEntity.ok().body(genre);
    }
}

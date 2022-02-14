package com.example.apiAnime.controller;

import com.example.apiAnime.domain.dto.AnimeError;
import com.example.apiAnime.domain.model.Anime;
import com.example.apiAnime.domain.model.Author;
import com.example.apiAnime.domain.model.projection.AnimeProjection;
import com.example.apiAnime.domain.model.projection.AuthorProjection;
import com.example.apiAnime.repository.AnimeRepository;
import com.example.apiAnime.repository.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorRepository authorRepository;
    AuthorController(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @GetMapping("/")
    public ResponseEntity<?> findAllAuthors(){
        return ResponseEntity.ok().body(authorRepository.findBy(AuthorProjection.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthor(@PathVariable UUID id){
        Author author = authorRepository.findById(id).orElse(null);

        if(author==null) return
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(AnimeError.message("No s'ha trobat l'autor amb l'id '" + id + "'"));
        return ResponseEntity.ok().body(author);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<?> searchAuthor(@PathVariable String keyword){
        String toSearch = keyword.toLowerCase();
        return ResponseEntity.ok().body(authorRepository.search(toSearch, AuthorProjection.class));
    }
}

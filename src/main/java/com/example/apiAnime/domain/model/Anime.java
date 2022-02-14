package com.example.apiAnime.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID animeid;
    public String name;
    public String description;
    public String type;
    public int year;
    public String imageurl;
    //public ArrayList<String> comments;

    @ManyToMany
    @JoinTable(name = "anime_author", joinColumns = @JoinColumn(name ="animeid"), inverseJoinColumns = @JoinColumn(name = "authorid"))
    public Set<Author> authors;

    @ManyToMany
    @JoinTable(name = "anime_genre", joinColumns = @JoinColumn(name ="animeid"), inverseJoinColumns = @JoinColumn(name = "genreid"))
    public Set<Genre> genres;

    @ManyToMany
    @JoinTable(name = "favourite", joinColumns = @JoinColumn(name ="animeid"), inverseJoinColumns = @JoinColumn(name = "userid"))
    public Set<User> favoritedby;

    @ManyToMany
    @JoinTable(name = "recomendations", joinColumns = @JoinColumn(name ="animeid"), inverseJoinColumns = @JoinColumn(name = "similaranimeid"))
    public Set<Anime> recomendations;

    @OneToMany(mappedBy = "anime")
    public Set<Comment> comments = new HashSet<>();
}

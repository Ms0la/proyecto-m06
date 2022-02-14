package com.example.apiAnime.domain.model;

import com.example.apiAnime.domain.model.compositekeys.AnimeUserKey;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "comments")
@IdClass(AnimeUserKey.class)
public class Comment {

    @Id
    public UUID animeid;

    @Id
    public UUID userid;

    public String comment;


    @ManyToOne
    @MapsId("animeid")
    @JoinColumn(name = "animeid")
    public Anime anime;

    @ManyToOne
    @MapsId("userid")
    @JoinColumn(name = "userid")
    public User user;
}

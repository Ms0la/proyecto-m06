package com.example.apiAnime.domain.model;


import com.example.apiAnime.domain.model.compositekeys.AnimeUserKey;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "favourite")
@IdClass(AnimeUserKey.class)
public class Favourite {
    @Id
    public UUID userid;
    @Id
    public UUID animeid;
}

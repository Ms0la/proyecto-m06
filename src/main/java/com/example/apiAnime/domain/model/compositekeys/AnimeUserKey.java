package com.example.apiAnime.domain.model.compositekeys;

import java.io.Serializable;
import java.util.UUID;

public class AnimeUserKey implements Serializable {
    public UUID animeid;
    public UUID userid;
}
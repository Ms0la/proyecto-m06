package com.example.apiAnime.domain.model;

import com.example.apiAnime.domain.model.compositekeys.FollowerFollowedKey;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name ="usertouser")
@IdClass(FollowerFollowedKey.class)
public class Follow {
    @Id
    public UUID followedid;
    @Id
    public UUID followerid;
}

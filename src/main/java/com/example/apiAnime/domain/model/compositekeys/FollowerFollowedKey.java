package com.example.apiAnime.domain.model.compositekeys;

import java.io.Serializable;
import java.util.UUID;

public class FollowerFollowedKey implements Serializable {
    public UUID followedid;
    public UUID followerid;
}

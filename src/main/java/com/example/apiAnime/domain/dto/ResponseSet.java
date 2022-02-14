package com.example.apiAnime.domain.dto;

import java.util.List;
import java.util.Set;

public class ResponseSet {
    public Set<?> result;

    public ResponseSet(Set<?> result) {
        this.result = result;
    }

    public static ResponseSet set(Set<?> list) {
        return new ResponseSet(list);
    }
}

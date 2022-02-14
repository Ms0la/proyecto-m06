package com.example.apiAnime.domain.dto;

import java.util.List;

public class ResponseList {
    public List<?> result;

    public ResponseList(List<?> result) {
        this.result = result;
    }

    public static ResponseList list(List<?> list) {
        return new ResponseList(list);
    }
}

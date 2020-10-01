package com.example.popehour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Gif {

    private String name;

    public String getFilePath(){
        return "/resources/static/gifs/" + name + ".gif";
    }
    public static List<Gif> GIFS = new ArrayList<>();
    static {
        GIFS.add(new Gif("papieska"));
        GIFS.add(new Gif("zly"));

    }
}

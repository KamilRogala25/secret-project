package com.example.popehour.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Music {

    private String name;

    public String getFilePath(){
        return "/resources/static/music/" + name + ".mp3";
    }
    public static List<Music> MUSIC = new ArrayList<>();
    static {
        MUSIC.add(new Music("papieska"));
        MUSIC.add(new Music("niepapieska"));

    }


}

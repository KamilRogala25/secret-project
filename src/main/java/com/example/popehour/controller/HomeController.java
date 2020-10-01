package com.example.popehour.controller;

import com.example.popehour.model.Gif;
import com.example.popehour.model.HourComparator;
import com.example.popehour.model.Music;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomePage(ModelMap map) {
        map.put("actualTime", HourComparator.getActualTime());
        map.put("targetTime", HourComparator.getTargetTime());
        map.put("howMuchLeft", HourComparator.howMuchLeft());
        if (HourComparator.compareHours()) {
            map.put("score", "Jest godzina papieska, jedzcie kremówki XD");
            Gif gif = Gif.GIFS.get(0);
            Music music = Music.MUSIC.get(0);
            map.put("music", music);
            map.put("gif", gif);
            return "score";
        }
        if (HourComparator.compareHours() == false)
            map.put("score", "Nie ma godziny papieskiej okrutniku XD");
            Gif gif = Gif.GIFS.get(1);
            Music music = Music.MUSIC.get(1);
            map.put("music", music);
            map.put("gif", gif);
        return "home";
    }

    @GetMapping("/2137")
    public String getPopeHour(ModelMap map) {
        map.put("score", "Jest godzina papieska, jedzcie kremówki XD");
        Gif gif = Gif.GIFS.get(0);
        Music music = Music.MUSIC.get(0);
        map.put("music", music);
        map.put("gif", gif);
        return "score";

    }
}



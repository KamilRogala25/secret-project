package com.example.popehour.controller;

import com.example.popehour.model.Gif;
import com.example.popehour.model.HourComparator;
import com.example.popehour.model.Music;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Timer;
import java.util.TimerTask;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomePage(ModelMap map) {
        Timer t = new Timer();
        map.put("actualTime", HourComparator.getActualTime());
        map.put("howMuchLeft", HourComparator.howMuchLeft());
        map.put("targetTime", HourComparator.getTargetTime());
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                map.replace("actualTime",HourComparator.updateActualTime());
//                System.out.println(HourComparator.updateActualTime());
                map.replace("howMuchLeft", HourComparator.updateDifference());
//                System.out.println(HourComparator.updateDifference());
            }
        },0,1000);
        if (map.get("actualTime").equals(map.get("targetTime"))) {
            map.put("score", "Jest godzina papieska, jedzcie kremówki XD");
            Gif gif = Gif.GIFS.get(0);
            Music music = Music.MUSIC.get(0);
            map.put("music", music);
            map.put("gif", gif);
            return "score";
        }
        if (!map.get("actualTime").equals(map.get("targetTime")))
            map.put("score", "Nie ma godziny papieskiej okrutniku XD");
            Gif gif = Gif.GIFS.get(1);
            Music music = Music.MUSIC.get(1);
            map.put("music", music);
            map.put("gif", gif);
        return "home";
    }

// todo przetestuj to wpisując czas
//    @GetMapping("/{time}")
//    public String testTime

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



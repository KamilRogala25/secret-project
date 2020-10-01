package com.example.popehour.model;

import lombok.Getter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

@EnableScheduling
public abstract class HourComparator {

    private static String actualTime;

    private static final String targetTime = "21:37";

    public static boolean compareHours() {
        if (actualTime.equalsIgnoreCase(targetTime)) {
            return true;
        } else return false;
    }

    public static String howMuchLeft() {
        updateActualTime();
        String[] actual = HourComparator.getActualTime().split(":");
        String[] target = HourComparator.getTargetTime().split(":");
        int hoursDiff = Integer.parseInt(target[0]) - Integer.parseInt(actual[0]);
        int minutesDiff = Integer.parseInt(target[1]) - Integer.parseInt(actual[1]);
        if (hoursDiff == 0 && minutesDiff > 0) {
            return "Do godziny papieskiej zostało " + minutesDiff + " minut.";
        }
        if (hoursDiff == 0 && minutesDiff < 0) {
            minutesDiff *=-1;
            return "Do godziny papieskiej zostało 23 godzin i " + minutesDiff + " minut.";
        }
        if (hoursDiff > 0 && minutesDiff > 0) {
            return "Do godziny papieskiej zostało " + hoursDiff + " godzin i " + minutesDiff + " minut.";
        }
        if (hoursDiff < 0 && minutesDiff > 0) {
            hoursDiff *= -1;
            return "Do godziny papieskiej zostało " + hoursDiff + " godzin i " + minutesDiff + " minut.";
        }
        if (hoursDiff > 0 && minutesDiff < 0) {
            minutesDiff = (minutesDiff * -1) + 37;
            return "Do godziny papieskiej zostało " + hoursDiff + " godzin i " + minutesDiff + " minut.";
        }
        if (hoursDiff < 0 && minutesDiff < 0) {
            hoursDiff *= -1;
            minutesDiff = (minutesDiff * -1) + 37;
            return "Do godziny papieskiej zostało " + hoursDiff + " godzin i " + minutesDiff + " minut.";
        }
        return "0";
    }
    public static String getActualTime() {
        actualTime = LocalTime.now().getHour() + ":" + LocalTime.now().getMinute();
        return actualTime;
    }

    @Scheduled(fixedRateString = "1000")
    public static void updateActualTime(){
        actualTime =getActualTime();
    }

    public static String getTargetTime() {
        return targetTime;
    }

}

package com.example.popehour.model;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalTime;

@EnableScheduling
public abstract class HourComparator {

    private static String actualTime;

    private static final String targetTime = "21:37";



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
            minutesDiff += 60;
            return "Do godziny papieskiej zostało 23 godzin i " + minutesDiff + " minut.";
        }
        if (hoursDiff == 1 && minutesDiff <0){
            minutesDiff += 60;
            return "Do godziny papieskiej zostało 1 godzina i" + minutesDiff + "minut";
        }
        if (hoursDiff > 0 && minutesDiff == 0) {
            return "Do godziny papieskiej zostało " + hoursDiff + " minut.";
        }
        if (hoursDiff < 0 && minutesDiff == 0) {
            hoursDiff += 24;
            return "Do godziny papieskiej zostało " + hoursDiff + " minut.";
        }
        if (hoursDiff > 0 && minutesDiff > 0) {
            return "Do godziny papieskiej zostało " + hoursDiff + " godzin i " + minutesDiff + " minut.";
        }
        if (hoursDiff < 0 && minutesDiff > 0) {
            hoursDiff += 24;
            return "Do godziny papieskiej zostało " + hoursDiff + " godzin i " + minutesDiff + " minut.";
        }
        if (hoursDiff > 0 && minutesDiff < 0) {
            minutesDiff += 60;
            return "Do godziny papieskiej zostało " + hoursDiff + " godzin i " + minutesDiff + " minut.";
        }
        if (hoursDiff < 0 && minutesDiff < 0) {
            hoursDiff += 24;
            minutesDiff += 60;
            return "Do godziny papieskiej zostało " + hoursDiff + " godzin i " + minutesDiff + " minut.";
        }
        return "0";
    }

    public static String howMuchLeftTest(int hours, int minutes) {
        String[] target = HourComparator.getTargetTime().split(":");
        int hoursDiff = Integer.parseInt(target[0]) - hours;
        int minutesDiff = Integer.parseInt(target[1]) - minutes;
        if (hoursDiff == 0 && minutesDiff > 0) {
            return Integer.toString(minutesDiff);
        }
        if (hoursDiff == 0 && minutesDiff < 0) {
            minutesDiff += 60;
            return "23:" + minutesDiff;
        }
        if (hoursDiff == 1 && minutesDiff <0){
            minutesDiff += 60;
            return "1:" + minutesDiff;
        }
        if (hoursDiff > 0 && minutesDiff == 0) {
            return Integer.toString(hoursDiff);
        }
        if (hoursDiff < 0 && minutesDiff == 0) {
            hoursDiff += 24;
            return Integer.toString(hoursDiff);
        }
        if (hoursDiff > 0 && minutesDiff > 0) {
            return hoursDiff + ":" + minutesDiff;
        }
        if (hoursDiff < 0 && minutesDiff > 0) {
            hoursDiff += 24;
            return hoursDiff + ":" + minutesDiff;
        }
        if (hoursDiff > 0 && minutesDiff < 0) {
            minutesDiff += 60;
            return hoursDiff + ":" + minutesDiff;
        }
        if (hoursDiff < 0 && minutesDiff < 0) {
            hoursDiff += 24;
            minutesDiff += 60;
            return hoursDiff + ":" + minutesDiff;
        }
        return "0";
    }

    public static String getActualTime() {
        actualTime = LocalTime.now().getHour() + ":" + LocalTime.now().getMinute();
        return actualTime;
    }


    public static String updateActualTime() {
        return actualTime = getActualTime();
    }

    public static String updateDifference() {
        return howMuchLeft();
    }

    public static String getTargetTime() {
        return targetTime;
    }

}

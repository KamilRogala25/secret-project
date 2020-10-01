package com.example.popehour.model;

import lombok.Getter;

import java.time.LocalTime;


public abstract class HourComparator {

    private static String actualTime = LocalTime.now().getHour() + ":" + LocalTime.now().getMinute();

    private static final String targetTime = "21:37";

    public static boolean compareHours(){
        if (actualTime.equalsIgnoreCase(targetTime)){
            return true;
        }
        else return false;
    }

    public static String howMuchLeft(){
        String[] actual = HourComparator.getActualTime().split(":");
        String[] target = HourComparator.getTargetTime().split(":");
        int hoursDiff = Integer.parseInt(target[0]) - Integer.parseInt(actual[0]);
        int minutesDiff = Integer.parseInt(target[1]) - Integer.parseInt(actual[1]);
        if (hoursDiff >0 && minutesDiff >0){
            return "Do godziny papieskiej zostało " + hoursDiff + " godzin i " + minutesDiff + " minut.";
        }
        if (hoursDiff <0 && minutesDiff >0){
            hoursDiff *= -1;
            return "Do godziny papieskiej zostało " + hoursDiff + " godzin i " + minutesDiff + " minut.";
        }
        if (hoursDiff >0 && minutesDiff <0){
            minutesDiff = (minutesDiff*-1) +37;
            return "Do godziny papieskiej zostało " + hoursDiff + " godzin i " + minutesDiff + " minut.";
        }
        if (hoursDiff <0 && minutesDiff <0){
            hoursDiff *= -1;
            minutesDiff = (minutesDiff*-1) +37;
            return "Do godziny papieskiej zostało " + hoursDiff + " godzin i " + minutesDiff + " minut.";
        }
        return "0";
    }

    public static String getActualTime() {
        return actualTime;
    }

    public static String getTargetTime() {
        return targetTime;
    }

}

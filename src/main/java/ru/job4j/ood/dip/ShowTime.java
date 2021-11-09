package ru.job4j.ood.dip;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ShowTime {
    private TimeArea timeArea;

    public ShowTime(TimeArea timeArea) {
        this.timeArea = timeArea;
    }

    public void showTime() {
        DateTimeFormatter formmat = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        System.out.println(timeArea.getLocalDateTime());
        String formatter = formmat.format(timeArea.getLocalDateTime());
        System.out.println(formatter);
    }

}

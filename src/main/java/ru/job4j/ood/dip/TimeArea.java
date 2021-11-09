package ru.job4j.ood.dip;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TimeArea {
    private LocalDateTime localDateTime;
    private String city;


    public TimeArea(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public TimeArea(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}

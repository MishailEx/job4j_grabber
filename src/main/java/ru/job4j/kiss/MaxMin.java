package ru.job4j.kiss;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxMin {

    private static <T> T compare(List<T> value, Comparator<T> comparator) {
        T buf = value.get(0);
        for (T t: value) {
            if (comparator.compare(buf, t) == -1) {
               buf = t;
            }
        }
        return buf;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return compare(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return compare(value, comparator);
    }
}
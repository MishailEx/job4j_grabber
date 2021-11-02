package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {

    private static <T> T compare(List<T> value, Comparator<T> comparator) {
        value.sort(comparator);
        return value.get(0);
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return compare(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return compare(value, comparator);
    }
}
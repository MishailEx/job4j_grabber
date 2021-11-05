package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {

    private static <T> T compare(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T buf = value.get(0);
        for (T t: value) {
            if (predicate.test(comparator.compare(buf, t))) {
               buf = t;
            }
        }
        return buf;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return compare(value, comparator, i -> i < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return compare(value, comparator, i -> i > 0);
    }
}
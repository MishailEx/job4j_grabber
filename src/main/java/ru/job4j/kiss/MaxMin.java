package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {

    private static <T> T compare(List<T> value, Comparator<T> comparator) {
        boolean check = false;
        T buf;
        while (!check) {
            check = true;
            for (int i = 0; i < value.size() - 1; i++) {
                if (comparator.compare(value.get(i), value.get(i + 1)) > 0) {
                    check = false;
                    buf = value.get(i);
                    value.set(i, value.get(i + 1));
                    value.set(i + 1, buf);
                }
            }
        }
        return value.get(0);
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return compare(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return compare(value, comparator);
    }
}
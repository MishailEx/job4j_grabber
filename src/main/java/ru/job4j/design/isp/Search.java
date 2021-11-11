package ru.job4j.design.isp;

import java.util.Map;

public interface Search<T, M> {
    Map<T, M> getMap();
}

package ru.job4j.design.isp;

import java.util.Map;

public interface Buttons {
    void add(Button button);
    Map<Integer, Button> getMap();
}

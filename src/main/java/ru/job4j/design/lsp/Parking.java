package ru.job4j.design.lsp;

import ru.job4j.design.lsp.cars.Car;

public interface Parking {
    int place();
    boolean takePlace(Car cars);
    void setPlace(int num);
}

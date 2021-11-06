package ru.job4j.design.lsp;

import ru.job4j.design.lsp.cars.Cars;

public interface Parking {
    int place();
    boolean takePlace(Cars cars);
    void setPlace(int size);
}

package ru.job4j.design.lsp.cars;

public class Passenger implements Car {
    public static final int CAR_SIZE = 1;

    @Override
    public int size() {
        return CAR_SIZE;
    }
}

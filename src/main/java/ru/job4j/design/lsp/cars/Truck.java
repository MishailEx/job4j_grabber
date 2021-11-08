package ru.job4j.design.lsp.cars;

public class Truck implements Car {
    private int size;

    public Truck(int size) {
        this.size = size * Passenger.CAR_SIZE;
    }

    @Override
    public int size() {
        return size;
    }
}

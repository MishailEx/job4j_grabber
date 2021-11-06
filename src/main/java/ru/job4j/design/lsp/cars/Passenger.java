package ru.job4j.design.lsp.cars;

import java.util.Objects;

public class Passenger implements Cars {
    private int size;

    public Passenger(int size) {
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Passenger passenger = (Passenger) o;
        return size == passenger.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }
}

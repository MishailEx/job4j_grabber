package ru.job4j.ood.lsp;

public class Car {
    int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    protected void validate(Car car) {
        if (speed < 1) {
            throw new IllegalArgumentException("this is not a car");
        }
    }
}

package ru.job4j.design.lsp;

import ru.job4j.design.lsp.cars.Car;

public class ParkingPass implements Parking {
    private int passPlace;

    public ParkingPass(int passPlace) {
        this.passPlace = passPlace;
    }

    public boolean takePlace(Car car) {
        boolean check = false;
        if (passPlace >= car.size()) {
            passPlace -= car.size();
            check = true;
            System.out.println("Авто припаркован");
        } else  {
            System.out.println("Мест нет");
        }
        return check;
    }

    public int getPassPlace() {
        return passPlace;
    }

    @Override
    public void setPlace(int passPlace) {
        this.passPlace = passPlace;
    }

    @Override
    public int place() {
        return passPlace;
    }
}

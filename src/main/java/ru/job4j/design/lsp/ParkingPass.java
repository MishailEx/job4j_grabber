package ru.job4j.design.lsp;

import ru.job4j.design.lsp.cars.Cars;

public class ParkingPass implements Parking {
    private int passPlace;

    public ParkingPass(int passPlace) {
        this.passPlace = passPlace;
    }

    public boolean takePlace(Cars cars) {
        boolean check = false;
        if (passPlace >= cars.size()) {
            passPlace -= cars.size();
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

    public void setPassPlace(int passPlace) {
        this.passPlace = passPlace;
    }

    @Override
    public int place() {
        return passPlace;
    }

    @Override
    public void setPlace(int size) {
        this.passPlace = size;
    }
}

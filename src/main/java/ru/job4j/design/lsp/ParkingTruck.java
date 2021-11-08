package ru.job4j.design.lsp;

import ru.job4j.design.lsp.cars.Car;

public class ParkingTruck implements Parking {
    private int truckPlace;

    public ParkingTruck(int truckPlace) {
        this.truckPlace = truckPlace;
    }

    @Override
    public boolean takePlace(Car car) {
        boolean check = false;
        if (truckPlace >= car.size()) {
            truckPlace -= car.size();
            check = true;
            System.out.println("Авто установлен на грузовой паркинг");
        }
        return check;
    }
    public int getTruckPlace() {
        return truckPlace;
    }
    @Override
    public void setPlace(int truckPlace) {
        this.truckPlace = truckPlace;
    }

    @Override
    public int place() {
        return truckPlace;
    }
}

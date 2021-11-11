package ru.job4j.design.lsp;

import ru.job4j.design.lsp.cars.Car;
import ru.job4j.design.lsp.cars.Passenger;

public class ParkingTruck implements Parking {
    private int truckPlace;

    public ParkingTruck(int truckPlace) {
        this.truckPlace = truckPlace;
    }

    @Override
    public boolean takePlace(Car car) {
        boolean check = false;
        if (car.size() > Passenger.CAR_SIZE) {
            if (truckPlace >= 1) {
                truckPlace -= 1;
                check = true;
                System.out.println("Авто установлен на грузовой паркинг");
            }
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

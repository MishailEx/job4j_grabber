package ru.job4j.design.lsp;

import ru.job4j.design.lsp.cars.Cars;

public class ParkingTruck implements Parking {
    private int truckPlace;
    private Parking parking;

    public ParkingTruck(int truckPlace, Parking parking) {
        this.truckPlace = truckPlace;
        this.parking = parking;
    }

    @Override
    public boolean takePlace(Cars cars) {
        boolean check = false;
        if (cars.size() > 1) {
            if (truckPlace >= cars.size()) {
                truckPlace -= cars.size();
                check = true;
                System.out.println("Авто установлен на грузовой паркинг");
            } else if (parking.place() >= cars.size()) {
                parking.setPlace(parking.place() - cars.size());
                check = true;
                System.out.println("Авто установлен на места легковушек");
            } else {
                System.out.println("Мест нет");
            }
        }
        if (cars.size() == 1) {
            parking.takePlace(cars);
        }
        return check;
    }
    public int getTruckPlace() {
        return truckPlace;
    }

    public void setTruckPlace(int truckPlace) {
        this.truckPlace = truckPlace;
    }

    @Override
    public int place() {
        return truckPlace;
    }

    @Override
    public void setPlace(int size) {
        this.truckPlace = size;
    }

}

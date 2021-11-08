package ru.job4j.design.lsp;

import ru.job4j.design.lsp.cars.Car;
import ru.job4j.design.lsp.cars.Passenger;

public class ParkingService {
    private Parking parkingCar;
    private Parking parkingTrack;

    public ParkingService(Parking parkingCar, Parking parkingTrack) {
        this.parkingCar = parkingCar;
        this.parkingTrack = parkingTrack;
    }

    public boolean takePlace(Car car) {
        boolean check = false;
        if (car.size() > Passenger.CAR_SIZE) {
            if (parkingTrack.takePlace(car)) {
                check = true;
            } else if (parkingCar.place() >= car.size()) {
                parkingCar.setPlace(parkingCar.place() - car.size());
                check = true;
                System.out.println("Авто установлен на места легковушек");
            } else {
                System.out.println("Мест нет");
            }
        }
        if (car.size() == Passenger.CAR_SIZE) {
            parkingCar.takePlace(car);
        }
        return check;
    }
}

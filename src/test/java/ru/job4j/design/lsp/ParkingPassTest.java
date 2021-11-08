package ru.job4j.design.lsp;

import org.junit.Test;
import ru.job4j.design.lsp.cars.Car;
import ru.job4j.design.lsp.cars.Passenger;
import ru.job4j.design.lsp.cars.Truck;

import static org.junit.Assert.*;

public class ParkingPassTest {
    @Test
    public void whenPassPlaceFree() {
        Car cars = new Passenger();
        Car cars1 = new Passenger();
        Parking parkingPass = new ParkingPass(2);
        Parking parkingTruck = new ParkingPass(6);
        ParkingService service = new ParkingService(parkingPass, parkingTruck);
        service.takePlace(cars);
        service.takePlace(cars1);
        int expected = parkingPass.place();
        assertEquals(expected, 0);
    }

    @Test
    public void whenPassPlaceBusy() {
        Car cars = new Passenger();
        Car cars1 = new Passenger();
        Parking parkingPass = new ParkingPass(1);
        Parking parkingTruck = new ParkingTruck(6);
        ParkingService service = new ParkingService(parkingPass, parkingTruck);
        service.takePlace(cars);
        assertFalse(service.takePlace(cars1));
    }

    @Test
    public void whenTruckPlaceBusy() {
        Car cars = new Truck(5);
        Car cars1 = new Truck(4);
        Parking parkingPass = new ParkingPass(6);
        Parking parkingTruck = new ParkingTruck(4);
        ParkingService service = new ParkingService(parkingPass, parkingTruck);
        service.takePlace(cars);
        service.takePlace(cars1);
        int expectedPass = parkingPass.place();
        int expectedTruck = parkingTruck.place();
        assertEquals(expectedPass, 1);
        assertEquals(expectedTruck, 0);
    }
}
package ru.job4j.design.lsp;

import org.junit.Test;
import ru.job4j.design.lsp.cars.Cars;
import ru.job4j.design.lsp.cars.Passenger;
import ru.job4j.design.lsp.cars.Truck;

import static org.junit.Assert.*;

public class ParkingPassTest {
    @Test
    public void whenPassPlaceFree() {
        Cars cars = new Passenger(1);
        Cars cars1 = new Passenger(1);
        Parking parking = new ParkingPass(2);
        parking.takePlace(cars);
        parking.takePlace(cars1);
        int expected = parking.place();
        assertEquals(expected, 0);
    }

    @Test
    public void whenPassPlaceBusy() {
        Cars cars = new Passenger(1);
        Cars cars1 = new Passenger(1);
        Parking parking = new ParkingPass(1);
        parking.takePlace(cars);
        assertFalse(parking.takePlace(cars1));
    }

    @Test
    public void whenTruckPlaceBusy() {
        Cars cars = new Truck(5);
        Cars cars1 = new Truck(4);
        Parking parkingPass = new ParkingPass(6);
        Parking parkingTruck = new ParkingTruck(4, parkingPass);
        parkingTruck.takePlace(cars);
        parkingTruck.takePlace(cars1);
        int expectedPass = parkingPass.place();
        int expectedTruck = parkingTruck.place();
        assertEquals(expectedPass, 1);
        assertEquals(expectedTruck, 0);
    }
}
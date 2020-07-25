package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void should_return_car_ticket_when_parking_lot_park_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        CarTicket carTicket = parkingLot.park(car);

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_car_when_fetch_car_from_parking_lot_given_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        CarTicket carTicket = parkingLot.park(car);

        //when
        Car fetchCar = parkingLot.fetch(carTicket);

        //then
        assertNotNull(fetchCar);
        assertEquals(car, fetchCar);

    }

    @Test
    void should_return_false_when_fetch_car_from_parking_lot_given_difference_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car carOne = new Car();
        Car carTwo = new Car();
        CarTicket carOneTicket = parkingLot.park(carOne);
        CarTicket carTwoTicket = parkingLot.park(carTwo);


        //when
        Car fetchCarOne = parkingLot.fetch(carOneTicket);
        Car fetchCarTwo = parkingLot.fetch(carTwoTicket);

        //given
        assertNotEquals(fetchCarOne, fetchCarTwo);
    }

    @Test
    void should_return_null_when_fetch_car_from_parking_lot_given_wrong_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        CarTicket wrongTicket = new CarTicket(car);

        //when
        Car fetchCar = parkingLot.fetch(wrongTicket);

        //given
        assertNull(fetchCar);

    }

    @Test
    void should_return_null_when_fetch_car_from_parking_lot_given_ticket_has_been_used() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        CarTicket carTicket = parkingLot.park(car);

        //when
        Car fetchCar = parkingLot.fetch(carTicket);
        Car secondFetchCar = parkingLot.fetch(carTicket);

        //given
        assertEquals(car, fetchCar);
        assertNull(secondFetchCar);
    }

}

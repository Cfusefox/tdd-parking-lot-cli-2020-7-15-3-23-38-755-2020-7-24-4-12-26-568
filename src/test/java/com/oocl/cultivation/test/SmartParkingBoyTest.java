package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmartParkingBoyTest {

    @Test
    void should_return_true_when_parking_car_into_parking_lot_given_two_car() {
        //given
        Car carOne = new Car();
        Car carTwo = new Car();
        Car carThree = new Car();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        //when
        CarTicket carTicket1 = smartParkingBoy.parkingCar(carOne);
        CarTicket carTicket2 = smartParkingBoy.parkingCar(carTwo);
        CarTicket carTicket3 = smartParkingBoy.parkingCar(carThree);
        Car fetchCar1 = parkingLot1.getParkingRoom().get(carTicket1);
        Car fetchCar2 = parkingLot2.getParkingRoom().get(carTicket2);
        Car fetchCar3 = parkingLot1.getParkingRoom().get(carTicket3);

        //then
        assertNotNull(fetchCar1);
        assertNotNull(fetchCar2);
        assertNotNull(fetchCar3);
    }

}

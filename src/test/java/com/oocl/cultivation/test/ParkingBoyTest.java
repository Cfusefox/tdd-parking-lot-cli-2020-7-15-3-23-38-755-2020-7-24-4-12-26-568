package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {

    @Test
    void should_return_car_ticket_when_parking_car_into_paring_lot_given_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        CarTicket carTicket = parkingBoy.parkingCar(car);

        //then
        assertNotNull(carTicket);
        assertEquals(car, carTicket.getCar());
    }

    @Test
    void should_return_car_when_fetch_car_from_parking_lot_when_given_car_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        CarTicket carTicket = parkingBoy.parkingCar(car);

        //when
        Car fetchCar = parkingBoy.fetchCar(carTicket);

        //given
        assertEquals(car, fetchCar);
    }

    @Test
    void should_return_null_when_fetch_car_from_parking_lot_when_given_null_ticket() {
        //given
        CarTicket carTicket = null;
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Car car = parkingBoy.fetchCar(carTicket);

        //then
        assertNull(car);
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_answer_customer_message_given_wrong_ticket() {
        //given
        Car car = new Car();
        CarTicket carTicket = new CarTicket(car);
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        String actual = parkingBoy.answerCustomerMessage(carTicket);

        //then
        assertEquals("Unrecognized parking ticket.", actual);
    }

    @Test
    void should_return_please_provide_your_parking_ticket_when_answer_customer_message_given_null_ticket() {
        //given
        Car car = new Car();
        CarTicket carTicket = new CarTicket(car);
        ParkingBoy parkingBoy = new ParkingBoy();

        //when
        String actual = parkingBoy.answerCustomerMessage(null);

        //then
        assertEquals("Please provide your parking ticket.", actual);
    }
}

package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {

    @Test
    void should_return_car_ticket_when_parking_car_into_paring_lot_given_car() {
        //given
        Car car = new Car();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy(parkingLots);

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
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy(parkingLots);


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
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy(parkingLots);

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
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        parkingBoy.fetchCar(carTicket);
        String actual = parkingBoy.answerCustomerMessage(carTicket);

        //then
        assertEquals("Unrecognized parking ticket.", actual);
    }

    @Test
    void should_return_please_provide_your_parking_ticket_when_answer_customer_message_given_null_ticket() {
        //given
        Car car = new Car();
        CarTicket carTicket = new CarTicket(car);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        String actual = parkingBoy.answerCustomerMessage(null);

        //then
        assertEquals("Please provide your parking ticket.", actual);
    }

    @Test
    void should_return_not_enough_position_when_answer_customer_message_given_null_but_had_give_car_to_boy() {
        //given
        ArrayList<Car> carList = new ArrayList<>();
        for(int index = 0; index < 11; index++) {
            carList.add(new Car());
        }
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        for(int number = 0; number < carList.size(); number++) {
            parkingBoy.parkingCar(carList.get(number));
        }
        String actual = parkingBoy.answerCustomerMessage(null);

        //then
        assertEquals("Not enough position.", actual);
    }

    @Test
    void should_return_true_when_parking_car_into_parking_lot_given_four_car() {
        //given
        Car carOne = new Car();
        Car carTwo = new Car();
        Car carThree = new Car();
        Car carFour = new Car();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(12);
        ParkingLot parkingLot2 = new ParkingLot(16);
        ParkingLot parkingLot3 = new ParkingLot(20);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        SuperSmartParkingBoy smartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        CarTicket carTicket1 = smartParkingBoy.parkingCar(carOne);
        CarTicket carTicket2 = smartParkingBoy.parkingCar(carTwo);
        CarTicket carTicket3 = smartParkingBoy.parkingCar(carThree);
        CarTicket carTicket4 = smartParkingBoy.parkingCar(carFour);
        Car fetchCar1 = parkingLot1.getParkingRoom().get(carTicket1);
        Car fetchCar2 = parkingLot2.getParkingRoom().get(carTicket2);
        Car fetchCar3 = parkingLot3.getParkingRoom().get(carTicket3);
        Car fetchCar4 = parkingLot3.getParkingRoom().get(carTicket4);

        //then
        assertNotNull(fetchCar1);
        assertNotNull(fetchCar2);
        assertNotNull(fetchCar3);
        assertNotNull(fetchCar4);
    }

}

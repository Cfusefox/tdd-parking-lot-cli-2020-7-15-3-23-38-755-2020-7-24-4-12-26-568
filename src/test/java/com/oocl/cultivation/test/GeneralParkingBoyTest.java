package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.GeneralParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GeneralParkingBoyTest {

    private static final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized parking ticket.";
    private static final String PLEASE_PROVIDE_YOUR_PARKING_TICKET = "Please provide your parking ticket.";
    private static final String NOT_ENOUGH_POSITION = "Not enough position.";

    @Test
    void should_return_car_ticket_when_parking_car_into_paring_lot_given_car() {
        //given
        Car car = new Car();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);
        GeneralParkingBoy parkingBoy = new GeneralParkingBoy(parkingLots);

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
        GeneralParkingBoy parkingBoy = new GeneralParkingBoy(parkingLots);


        CarTicket carTicket = parkingBoy.parkingCar(car);

        //when
        Car fetchCar = parkingBoy.fetchCar(carTicket);

        //given
        assertEquals(car, fetchCar);
    }

    @Test
    void should_return_null_when_fetch_car_from_parking_lot_when_given_null_ticket() {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);
        GeneralParkingBoy parkingBoy = new GeneralParkingBoy(parkingLots);

        //when
        Car car = parkingBoy.fetchCar(null);

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
        GeneralParkingBoy parkingBoy = new GeneralParkingBoy(parkingLots);

        //when
        parkingBoy.fetchCar(carTicket);
        String actual = parkingBoy.answerCustomerMessage(carTicket);

        //then
        assertEquals(UNRECOGNIZED_PARKING_TICKET, actual);
    }

    @Test
    void should_return_please_provide_your_parking_ticket_when_answer_customer_message_given_null_ticket() {
        //given
        Car car = new Car();
        CarTicket carTicket = new CarTicket(car);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);
        GeneralParkingBoy parkingBoy = new GeneralParkingBoy(parkingLots);

        //when
        String actual = parkingBoy.answerCustomerMessage(null);

        //then
        assertEquals(PLEASE_PROVIDE_YOUR_PARKING_TICKET, actual);
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
        GeneralParkingBoy parkingBoy = new GeneralParkingBoy(parkingLots);

         //when
        for (Car car : carList) {
            parkingBoy.parkingCar(car);
        }
        String actual = parkingBoy.answerCustomerMessage(null);

        //then
        assertEquals(NOT_ENOUGH_POSITION, actual);
    }

    @Test
    void should_return_true_when_parking_car_into_parking_lot_given_many_car() {
        //given
        ArrayList<Car> newCarList = new ArrayList<>();
        for(int index = 0; index < 11; index++) {
            newCarList.add(new Car());
        }
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        GeneralParkingBoy parkingBoy = new GeneralParkingBoy(parkingLots);
        ArrayList<Car> parkedCarList = new ArrayList<>();

        //when
        for(int number = 0; number < 10; number++) {
            parkingBoy.parkingCar(newCarList.get(number));
        }
        CarTicket eleventhCarTiclet = parkingBoy.parkingCar(newCarList.get(10));
        LinkedHashMap<CarTicket, Car> parkingRoom = parkingLot1.getParkingRoom();
        for (Map.Entry<CarTicket, Car> entry : parkingRoom.entrySet()) {
            parkedCarList.add(entry.getValue());
        }

        //then
        for(int unit = 0; unit < 10; unit++) {
            assertEquals(newCarList.get(unit), parkedCarList.get(unit));
        }
        assertEquals(newCarList.get(10), parkingLot2.getParkingRoom().get(eleventhCarTiclet));
    }

}

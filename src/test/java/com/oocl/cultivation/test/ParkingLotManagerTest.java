package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ParkingLotManagerTest {

    private static final String NOT_ENOUGH_POSITION = "Not enough position.";

    @Test
    void should_return_true_when_parking_car_given_car() {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);
        Car car = new Car();
        GeneralParkingBoy generalParkingBoy = new GeneralParkingBoy(parkingLots);
        ParkingLotManager parkingLotManager = new ParkingLotManager(generalParkingBoy, parkingLot);


        //when
        CarTicket carTicket = parkingLotManager.parkingCar(car);
        Car fetchCar = parkingLotManager.fetchCar(carTicket);

        //given
        assertEquals(car, fetchCar);
    }

    @Test
    void should_return_true_when_parking_lot_manager_parking_car_given_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLot);

        //when
        CarTicket carTicket = parkingLotManager.parkingCar(car);
        Car fetchCar = parkingLotManager.fetchCar(carTicket);

        //given
        assertEquals(car, fetchCar);

    }

    @Test
    void should_return_error_message_when_answer_customer_message_given_ticket() {
        //given
        ArrayList<Car> carList = new ArrayList<>();
        for (int index = 0; index < 11; index++) {
            carList.add(new Car());
        }
        ParkingLot parkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        GeneralParkingBoy generalParkingBoy = new GeneralParkingBoy(parkingLots);
        ParkingLotManager parkingLotManager = new ParkingLotManager(generalParkingBoy);

        //when
        for (int number = 0; number < 11; number++) {
            parkingLotManager.parkingCar(carList.get(number));
        }
        String actual = parkingLotManager.answerCustomerMessage(null);

        //given
        assertEquals(NOT_ENOUGH_POSITION, actual);
    }

}

package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ParkingLotManagerTest {

    @Test
    void should_return_true_when_add_parking_boy_to_manage_list_given_parking_boy() {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        GeneralParkingBoy generalParkingBoy = new GeneralParkingBoy(parkingLots);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        boolean actual1 = parkingLotManager.addParkingBoy(generalParkingBoy);
        boolean actual2 = parkingLotManager.addParkingBoy(smartParkingBoy);
        boolean actual3 = parkingLotManager.addParkingBoy(superSmartParkingBoy);

        //given
        assertTrue(actual1);
        assertTrue(actual2);
        assertTrue(actual3);
    }

    @Test
    void should_return_true_when_parking_car_given_car() {
        //given
        ArrayList<ParkingCarBehavior> parkingAbles = new ArrayList<>();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLots.add(parkingLot);
        Car car = new Car();
        GeneralParkingBoy generalParkingBoy = new GeneralParkingBoy(parkingLots);
        parkingAbles.add(generalParkingBoy);
        parkingAbles.add(parkingLot);
        ParkingLotManager parkingLotManager = new ParkingLotManager();


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
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingLotManager parkingLotManager = new ParkingLotManager();

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
        for(int index = 0; index < 11; index++) {
            carList.add(new Car());
        }
        ParkingLot parkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        GeneralParkingBoy generalParkingBoy = new GeneralParkingBoy(parkingLots);
        parkingLotManager.addParkingBoy(generalParkingBoy);

        //when
        for(int number = 0; number < 11; number++) {
            parkingLotManager.parkingCar(carList.get(number));
        }
        String actual = parkingLotManager.answerCustomerMessage(null);

        //given
        assertEquals("Not enough position.", actual);
    }

}

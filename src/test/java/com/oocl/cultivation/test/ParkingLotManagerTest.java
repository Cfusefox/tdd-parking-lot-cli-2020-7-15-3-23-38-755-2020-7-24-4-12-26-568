package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ParkingLotManagerTest {

    @Test
    void should_return_true_when_add_parking_boy_to_manage_list_given_parking_boy() {
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots);
        ParkingBoy generalParkingBoy = new GeneralParkingBoy(parkingLots);
        ParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        boolean actual1 = parkingLotManager.addParkingBoy(generalParkingBoy);
        boolean actual2 = parkingLotManager.addParkingBoy(smartParkingBoy);
        boolean actual3 = parkingLotManager.addParkingBoy(superSmartParkingBoy);

        //given
        assertTrue(actual1);
        assertTrue(actual2);
        assertTrue(actual3);
    }


}

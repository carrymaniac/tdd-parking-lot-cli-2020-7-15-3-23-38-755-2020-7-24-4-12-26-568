package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotServiceManagerTest {

    @Test
    void should_park_4_car_when_park_given_two_parking_boy_and_two_parking_lot_and_4_car() {
        ParkingLot parkingLotA = new ParkingLot(1);
        ParkingLot parkingLotB = new ParkingLot(1);
        ParkingBoy parkingBoy = new NormalParkingBoy(Arrays.asList(new ParkingLot(1)));
        ParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(1),new ParkingLot(1)));
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingLotA,parkingLotB,parkingBoy,smartParkingBoy);
        List<ParkResult> parkResults = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            parkingLotServiceManager.park(new Car());
        }
        assertEquals(4,parkResults.size());
        parkResults.stream().forEach(parkResult -> {
            assertNotNull(parkResult.getCarTicket());
        });
    }
}

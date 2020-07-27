package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NormalParkingBoyTest {
    @Test
    void should_return_park_result_when_park_given_car() {
        //given
        Car car = new Car();
        NormalParkingBoy boy = new NormalParkingBoy(Arrays.asList(new ParkingLot()));
        //when
        ParkResult parkResult = boy.park(car);
        //then
        assertNotNull(parkResult);
    }

    @Test
    void should_return_fetch_result_when_fetch_given_car_ticket() {
        //given
        Car car = new Car();
        NormalParkingBoy boy = new NormalParkingBoy(Arrays.asList(new ParkingLot()));
        CarTicket carTicket = boy.park(car).getCarTicket();
        //when
        FetchResult fetchResult = boy.fetch(carTicket);
        //then
        assertNotNull(fetchResult);
        assertEquals(car, fetchResult.getCar());
    }


    @Test
    void should_return_success_park_result_when_park_given_11_cars() {
        NormalParkingBoy boy = new NormalParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));
        for (int i = 0; i < 10; i++) {
            boy.park(new Car());
        }
        ParkResult parkResult = boy.park(new Car());
        assertNotNull(parkResult);
        assertNotNull(parkResult.getCarTicket());
    }

    @Test
    void should_return_success_fetch_result_when_fetch_given_11st_car_ticket() {
        NormalParkingBoy boy = new NormalParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));
        for (int i = 0; i < 10; i++) {
            boy.park(new Car());
        }
        CarTicket carTicket = boy.park(new Car()).getCarTicket();
        FetchResult fetchResult = boy.fetch(carTicket);
        assertNotNull(fetchResult);
        assertNotNull(fetchResult.getCar());
    }


}

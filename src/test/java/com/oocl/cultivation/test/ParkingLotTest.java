package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_car_ticket_when_park_given_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        //when
        CarTicket carTicket = parkingLot.park(car);
        //then
        assertNotNull(carTicket);
    }


    @Test
    void should_fetch_car_when_fetch_given_car_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicket = parkingLot.park(car);
        //when
        Car fetchCar = parkingLot.fetch(carTicket);
        //then
        assertNotNull(fetchCar);
        assertEquals(car, fetchCar);
    }

    @Test
    void should_fetch_null_when_fetch_given_wrong_ticket(){
        //given
        CarTicket carTicket = new CarTicket();
        ParkingLot parkingLot = new ParkingLot();
        //when
        Car fetch = parkingLot.fetch(carTicket);
        //then
        assertNull(fetch);
    }
}

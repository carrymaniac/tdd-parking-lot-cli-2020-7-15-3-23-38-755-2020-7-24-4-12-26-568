package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_car_ticket_when_park_given_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        //when
        CarTicket carTicket = parkingLot.park(car).getCarTicket();
        //then
        assertNotNull(carTicket);
    }


    @Test
    void should_fetch_car_when_fetch_given_car_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicket = parkingLot.park(car).getCarTicket();
        //when
        Car fetchCar = parkingLot.fetch(carTicket).getCar();
        //then
        assertNotNull(fetchCar);
        assertEquals(car, fetchCar);
    }

    @Test
    void should_fetch_right_car_when_fetch_given_correspond_ticket() {
        //given
        Car carA = new Car();
        Car carB = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicketA = parkingLot.park(carA).getCarTicket();
        CarTicket carTicketB = parkingLot.park(carB).getCarTicket();
        //when
        Car fetchCarA = parkingLot.fetch(carTicketA).getCar();
        Car fetchCarB = parkingLot.fetch(carTicketB).getCar();
        //then
        assertNotNull(fetchCarA);
        assertNotNull(fetchCarB);
        assertEquals(carA, fetchCarA);
        assertEquals(carB, fetchCarB);
        assertNotEquals(fetchCarA, fetchCarB);
    }

    //todo
    @Test
    void should_fetch_error_message_when_fetch_given_wrong_ticket() {
        //given
        CarTicket carTicket = new CarTicket();
        ParkingLot parkingLot = new ParkingLot();
        //when
        FetchResult fetch = parkingLot.fetch(carTicket);
        //then
        assertNotNull(fetch);
        assertEquals("Unrecognized parking ticket.", fetch.getMessage());
    }

    @Test
    void should_fetch_error_message_when_fetch_given_null() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        //when
        FetchResult fetch = parkingLot.fetch(null);
        //then
        assertNotNull(fetch);
        assertEquals("Please provide your parking ticket.", fetch.getMessage());
    }

    @Test
    void should_fetch_error_message_when_fetch_given_used_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicket = parkingLot.park(car).getCarTicket();
        //when
        Car fetchCar = parkingLot.fetch(carTicket).getCar();
        FetchResult fetchResult = parkingLot.fetch(carTicket);
        //then
        assertNotNull(fetchResult);
        assertEquals("Unrecognized parking ticket.", fetchResult.getMessage());
    }

    @Test
    void should_return_error_message_when_park_given_11_tickets() {
        ParkingLot parkingLot = new ParkingLot(10);
        for (int i = 0; i < 10; i++) {
            parkingLot.park(new Car());
        }
        ParkResult parkResult = parkingLot.park(new Car());
        assertNotNull(parkResult);
        assertEquals("Not enough position.", parkResult.getMessage());
    }

}

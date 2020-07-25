package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.FetchResult;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        CarTicket carTicketA = parkingLot.park(carA);
        CarTicket carTicketB = parkingLot.park(carB);
        //when
        Car fetchCarA = parkingLot.fetch(carTicketA).getCar();
        Car fetchCarB = parkingLot.fetch(carTicketB).getCar();
        //then
        assertNotNull(fetchCarA);
        assertNotNull(fetchCarB);
        assertEquals(carA, fetchCarA);
        assertEquals(carB, fetchCarB);
        assertNotEquals(fetchCarA,fetchCarB);
    }

    //todo
    @Test
    void should_fetch_error_message_when_fetch_given_wrong_ticket(){
        //given
        CarTicket carTicket = new CarTicket();
        ParkingLot parkingLot = new ParkingLot();
        //when
        FetchResult fetch = parkingLot.fetch(carTicket);
        //then
        assertNotNull(fetch);
        assertEquals("Unrecognized parking ticket.",fetch.getMessage());
    }

    @Test
    void should_fetch_null_when_fetch_given_null(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        //when
        Car fetch = parkingLot.fetch(null).getCar();
        //then
        assertNull(fetch);
    }

    @Test
    void should_fetch_null_when_fetch_given_used_ticket(){
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicket = parkingLot.park(car);
        //when
        Car fetchCar = parkingLot.fetch(carTicket).getCar();
        Car fetchAgainCar = parkingLot.fetch(carTicket).getCar();
        //then
        assertNull(fetchAgainCar);
    }
    @Test
    void should_return_null_when_park_given_11_tickets() {
        ArrayList<Car> cars = new ArrayList<>();
        for(int i = 0;i<11;i++){
            cars.add(new Car());
        }
        ParkingLot parkingLot = new ParkingLot(10);
        for(int i = 0;i<10;i++){
            parkingLot.park(cars.get(i));
        }
        CarTicket park = parkingLot.park(cars.get(10));
        assertNull(park);
    }

}

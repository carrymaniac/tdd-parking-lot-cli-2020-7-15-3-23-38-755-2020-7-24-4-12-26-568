package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ProjectName: parking-lot
 * @Package: com.oocl.cultivation.test
 * @ClassName: ParkingBoyTest
 * @Author: carrymaniac
 * @Description:
 * @Date: 2020/7/24 3:44 下午
 * @Version:
 */
public class ParkingBoyTest {
    @Test
    void should_return_car_ticket_when_park_given_car() {
        //given
        Car car = new Car();
        ParkingBoy boy = new ParkingBoy(new ParkingLot());
        //when
        CarTicket carTicket = boy.park(car);
        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_fetch_car_when_fetch_given_car_ticket() {
        //given
        Car car = new Car();
        ParkingBoy boy = new ParkingBoy(new ParkingLot());
        CarTicket carTicket = boy.park(car);
        //when
        Car fetchCar = boy.fetch(carTicket);
        //then
        assertNotNull(fetchCar);
        assertEquals(car,fetchCar);
    }

    @Test
    void should_return_null_when_park_given_parked_car(){
        //given
        Car car = new Car();
        ParkingBoy boy = new ParkingBoy(new ParkingLot());
        CarTicket carTicket = boy.park(car);
        //when
        CarTicket parkAgain = boy.park(car);
        assertNull(parkAgain);
    }

}

package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
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
    void should_return_park_result_when_park_given_car() {
        //given
        Car car = new Car();
        ParkingBoy boy = new ParkingBoy(new ParkingLot());
        //when
        ParkResult parkResult = boy.park(car);
        //then
        assertNotNull(parkResult);
    }

    @Test
    void should_return_fetch_result_when_fetch_given_car_ticket() {
        //given
        Car car = new Car();
        ParkingBoy boy = new ParkingBoy(new ParkingLot());
        CarTicket carTicket = boy.park(car).getCarTicket();
        //when
        FetchResult fetchResult = boy.fetch(carTicket);
        //then
        assertNotNull(fetchResult);
        assertEquals(car,fetchResult.getCar());
    }


}

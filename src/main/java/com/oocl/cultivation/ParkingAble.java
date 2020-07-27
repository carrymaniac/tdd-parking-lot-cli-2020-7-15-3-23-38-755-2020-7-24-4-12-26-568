package com.oocl.cultivation;

public interface ParkingAble {
    ParkResult park(Car car);
    FetchResult fetch(CarTicket carTicket);
    int getRemainingPosition();
}

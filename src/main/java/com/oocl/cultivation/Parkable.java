package com.oocl.cultivation;

public interface Parkable {
    ParkResult park(Car car);
    FetchResult fetch(CarTicket carTicket);
    int getRemainingPosition();
}

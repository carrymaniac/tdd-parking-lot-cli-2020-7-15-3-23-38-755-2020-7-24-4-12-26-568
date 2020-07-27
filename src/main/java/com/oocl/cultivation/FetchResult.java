package com.oocl.cultivation;

import java.util.Objects;


public class FetchResult {
    private String message;
    private Car car;

    public FetchResult(String message, Car car) {
        this.message = message;
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FetchResult that = (FetchResult) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(car, that.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, car);
    }

    public String getMessage() {
        return message;
    }

    public Car getCar() {
        return car;
    }

}

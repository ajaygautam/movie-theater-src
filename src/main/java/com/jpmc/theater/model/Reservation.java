package com.jpmc.theater.model;

import lombok.Value;

@Value
public class Reservation {
    private Customer customer;
    private Showing showing;
    private int audienceCount;

    public double totalFee() {
        return showing.getTicketPrice() * audienceCount;
    }
}
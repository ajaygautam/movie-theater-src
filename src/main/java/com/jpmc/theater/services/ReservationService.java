package com.jpmc.theater.services;

import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.model.Theater;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ReservationService {
    private Theater theater;

    public Reservation reserve(Customer customer, int sequence, int howManyTickets) {
        final List<Showing> schedule = theater.getSchedule();
        final Showing showing = schedule.size() >= sequence ? schedule.get(sequence - 1) : null;
        if (showing == null) {
            throw new IllegalArgumentException("Showing with sequence " + sequence + " not found in schedule!");
        }
        return new Reservation(customer, showing, howManyTickets);
    }
}

package com.jpmc.theater.model;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservationTests {
    @Test
    void totalFee() {
        final var customer = new Customer("John Doe", "unused-id");
        final var movie = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90));
        final var showing = new Showing(movie, 1, LocalDateTime.now(), 12.5, 1);
        assertEquals(37.5, new Reservation(customer, showing, 3).totalFee());
    }
}

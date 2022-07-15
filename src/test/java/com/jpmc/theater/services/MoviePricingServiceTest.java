package com.jpmc.theater.services;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Showing;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class MoviePricingServiceTest {
    @Test
    void specialMovieHas20PercentDiscount() {
        final double ticketPrice = 12.5;
        final double expectedDiscount = 0.2; // 20%
        final double expectedTicketPrice = ticketPrice * (1 - expectedDiscount);

        final Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90));
        final Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now()), ticketPrice, 1);
        assertEquals(expectedTicketPrice, new MoviePricingService().calculateTicketPrice(showing));
    }

    @Test
    void showingBetween11And4Have25PercentDiscount() {
        final double ticketPrice = 12.5;
        final double expectedDiscount = 0.25;
        final double expectedTicketPrice = ticketPrice * (1 - expectedDiscount);

        final Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90));
        final Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(14,0)), ticketPrice, 0);
        assertEquals(expectedTicketPrice, new MoviePricingService().calculateTicketPrice(showing));
    }

    @Test
    void Dollar3DiscountForMovieOn1stOfDay() {
        final double ticketPrice = 12.5;
        final double expectedDiscount = 3.0; // $
        final double expectedTicketPrice = ticketPrice - expectedDiscount;

        final Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90));
        final Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.now()), ticketPrice, 0);
        assertEquals(expectedTicketPrice, new MoviePricingService().calculateTicketPrice(showing));
    }

    @Test
    void Dollar2DiscountForMovieOn2ndOfDay() {
        final double ticketPrice = 12.5;
        final double expectedDiscount = 2.0; // $
        final double expectedTicketPrice = ticketPrice - expectedDiscount;

        final Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90));
        final Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.now()), ticketPrice, 0);
        assertEquals(expectedTicketPrice, new MoviePricingService().calculateTicketPrice(showing));
    }

    @Test
    void Dollar1DiscountForMovieOn7thOfDay() {
        final double ticketPrice = 12.5;
        final double expectedDiscount = 1.0; // $
        final double expectedTicketPrice = ticketPrice - expectedDiscount;

        final Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90));
        final Showing showing = new Showing(spiderMan, 7, LocalDateTime.of(LocalDate.now(), LocalTime.now()), ticketPrice, 0);
        assertEquals(expectedTicketPrice, new MoviePricingService().calculateTicketPrice(showing));
    }

}
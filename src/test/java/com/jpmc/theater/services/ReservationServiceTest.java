package com.jpmc.theater.services;

import com.jpmc.theater.TestsHelper;
import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.model.Theater;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservationServiceTest {
    @Test
    void verifyErrorThrownWhenShowingNotFound() {
        final Theater theater = new Theater(TestsHelper.scheduleForTesting(LocalDate.of(2022, 7, 14)));
        final var reservationService = new ReservationService(theater);
        var actualException = assertThrows(IllegalArgumentException.class, () -> reservationService.reserve(new Customer("John Doe", "id-12345"), 22, 4));
        assertNotNull(actualException);
        assertTrue(actualException.getMessage().matches("Showing with sequence .* not found in schedule!"));
    }

    @Test
    void verifyTotalFeeForCustomer() {
        final Theater theater = new Theater(TestsHelper.scheduleForTesting(LocalDate.of(2022, 7, 14)));
        Reservation reservation = new ReservationService(theater).reserve(new Customer("John Doe", "id-12345"), 2, 4);
        assertEquals(50, reservation.totalFee());
    }

}
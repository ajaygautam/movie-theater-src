package com.jpmc.theater;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.util.LocalDateProvider;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class TestsHelper {
    public static List<Showing> scheduleForTesting(LocalDate showingDate) {
        final Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90));
        final Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85));
        final Movie theBatMan = new Movie("The Batman", Duration.ofMinutes(95));
        final LocalDateProvider provider = LocalDateProvider.get();
        return List.of(
                new Showing(turningRed, 1, LocalDateTime.of(showingDate, LocalTime.of(9, 0)), 11, 0),
                new Showing(spiderMan, 2, LocalDateTime.of(showingDate, LocalTime.of(11, 0)), 12.5, 1),
                new Showing(theBatMan, 3, LocalDateTime.of(showingDate, LocalTime.of(12, 50)), 9, 0),
                new Showing(turningRed, 4, LocalDateTime.of(showingDate, LocalTime.of(14, 30)), 11, 0),
                new Showing(spiderMan, 5, LocalDateTime.of(showingDate, LocalTime.of(16, 10)), 12.5, 1),
                new Showing(theBatMan, 6, LocalDateTime.of(showingDate, LocalTime.of(17, 50)), 9, 0),
                new Showing(turningRed, 7, LocalDateTime.of(showingDate, LocalTime.of(19, 30)), 11, 0),
                new Showing(spiderMan, 8, LocalDateTime.of(showingDate, LocalTime.of(21, 10)), 12.5, 1),
                new Showing(theBatMan, 9, LocalDateTime.of(showingDate, LocalTime.of(23, 0)), 9, 0)
        );
    }
}

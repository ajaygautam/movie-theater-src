package com.jpmc.theater.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class LocalDateProviderTests {
    @Test
    void makeSureCurrentTimeIsAvailable() {
        final LocalDate localDate = LocalDateProvider.get().currentDate();
        Assertions.assertNotNull(localDate);
    }
}

package com.jpmc.theater.util;

import java.time.LocalDate;

public class LocalDateProvider {
    private static final LocalDateProvider instance = new LocalDateProvider();

    public static LocalDateProvider get() {
        return instance;
    }

    public LocalDate currentDate() {
        return LocalDate.now();
    }
}

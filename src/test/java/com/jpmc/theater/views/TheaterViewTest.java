package com.jpmc.theater.views;

import com.jpmc.theater.TestsHelper;
import com.jpmc.theater.model.Theater;
import com.jpmc.theater.util.LocalDateProvider;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

class TheaterViewTest {
    @Test
    void verifyScheduleExportToJson() throws Exception {
        final LocalDate showingDate = LocalDate.of(2022, 7, 14);
        final String expectedJson = IOUtils.toString(this.getClass().getResourceAsStream("/test-schedule.json"), StandardCharsets.UTF_8);
        final String actualOutput = new TheaterView(new Theater(TestsHelper.scheduleForTesting(showingDate))).scheduleToJson();
        JSONAssert.assertEquals(expectedJson, actualOutput, JSONCompareMode.STRICT);
    }

    @Test
    void printMovieSchedulePlainText() {
        final LocalDate showingDate = LocalDate.of(2022, 7, 14);
        final String expectedPlainTextOut = LocalDateProvider.get().currentDate() + "\n" +
                "===================================================\n" +
                "1: 2022-07-14T09:00 Turning Red (1 hour 25 minutes) $11.0\n" +
                "2: 2022-07-14T11:00 Spider-Man: No Way Home (1 hour 30 minutes) $12.5\n" +
                "3: 2022-07-14T12:50 The Batman (1 hour 35 minutes) $9.0\n" +
                "4: 2022-07-14T14:30 Turning Red (1 hour 25 minutes) $11.0\n" +
                "5: 2022-07-14T16:10 Spider-Man: No Way Home (1 hour 30 minutes) $12.5\n" +
                "6: 2022-07-14T17:50 The Batman (1 hour 35 minutes) $9.0\n" +
                "7: 2022-07-14T19:30 Turning Red (1 hour 25 minutes) $11.0\n" +
                "8: 2022-07-14T21:10 Spider-Man: No Way Home (1 hour 30 minutes) $12.5\n" +
                "9: 2022-07-14T23:00 The Batman (1 hour 35 minutes) $9.0\n" +
                "===================================================\n";
        final String actualOutput = new TheaterView(new Theater(TestsHelper.scheduleForTesting(showingDate))).printSchedulePlainText();

        Assertions.assertEquals(expectedPlainTextOut, actualOutput);
    }
}
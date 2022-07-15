package com.jpmc.theater.views;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jpmc.theater.model.Theater;
import com.jpmc.theater.util.LocalDateProvider;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class TheaterView {
    private Theater theater;

    public String scheduleToJson() throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        final ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(theater.getSchedule());
    }

    public String printSchedulePlainText() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(LocalDateProvider.get().currentDate()).append("\n");
        buffer.append("===================================================").append("\n");
        theater.getSchedule().forEach(s ->
                buffer.append(s.getSequenceOfTheDay())
                        .append(": ")
                        .append(s.getShowStartTime()).append(" ")
                        .append(s.getMovie().getTitle()).append(" ")
                        .append(humanReadableFormat(s.getMovie().getRunningTime()))
                        .append(" $").append(s.getTicketPrice())
                        .append("\n")
        );
        buffer.append("===================================================").append("\n");
        final String output = buffer.toString();
        System.out.print(output);
        return output;
    }

    private static String humanReadableFormat(Duration duration) {
        long hour = duration.toHours();
        long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(duration.toHours());

        return String.format("(%s hour%s %s minute%s)", hour, handlePlural(hour), remainingMin, handlePlural(remainingMin));
    }

    // (s) postfix should be added to handle plural correctly
    private static String handlePlural(long value) {
        if (value == 1) {
            return "";
        } else {
            return "s";
        }
    }
}

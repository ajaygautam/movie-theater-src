package com.jpmc.theater.services;

import com.jpmc.theater.model.Showing;

import java.util.stream.Stream;

public class MoviePricingService {
    private static final int MOVIE_CODE_SPECIAL = 1;

    public double calculateTicketPrice(Showing showing) {
        return showing.getTicketPrice() - getDiscount(showing);
    }

    private double getDiscount(Showing showing) {
        return Stream.of(
                        calculateSpecialDiscount(showing),
                        calculateTimeDiscount(showing),
                        calculateSequenceDiscount(showing.getSequenceOfTheDay()))
                .max(Double::compare).get();
    }

    private double calculateSpecialDiscount(Showing showing) {
        double specialDiscount = 0;
        if (MOVIE_CODE_SPECIAL == showing.getSpecialCode()) {
            specialDiscount = showing.getTicketPrice() * 0.2;
        }
        return specialDiscount;
    }

    private double calculateSequenceDiscount(int showSequence) {
        double sequenceDiscount = 0;
        switch (showSequence) {
            case 1:
                sequenceDiscount = 3;
                break;
            case 2:
                sequenceDiscount = 2;
                break;
            case 7:
                sequenceDiscount = 1;
                break;
        }
        return sequenceDiscount;
    }

    private double calculateTimeDiscount(Showing showing) {
        double timeDiscount = 0;
        final int showStartHour = showing.getShowStartTime().getHour();
        if (showStartHour >= 11 && showStartHour < 16) {
            timeDiscount = showing.getTicketPrice() * 0.25;
        }
        return timeDiscount;
    }
}

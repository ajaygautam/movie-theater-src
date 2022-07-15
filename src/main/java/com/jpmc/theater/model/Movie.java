package com.jpmc.theater.model;

import lombok.Value;

import java.time.Duration;

@Value
public class Movie {
    private String title;
    private Duration runningTime;
}
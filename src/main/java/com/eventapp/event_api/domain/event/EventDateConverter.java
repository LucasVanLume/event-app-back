package com.eventapp.event_api.domain.event;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class EventDateConverter {

    public static LocalDate convertStringToLocalDate(String dateString) {
        if (dateString == null || dateString.isBlank()) {
            throw new IllegalArgumentException("A data não pode ser nula ou vazia.");
        }

        Instant instant = Instant.parse(dateString);
        return LocalDate.ofInstant(instant, ZoneOffset.UTC);
    }
}

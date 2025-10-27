package com.example.hmrback.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static final String DATE_FORMAT = "dd/MM/yyyy";

    private DateUtils() {
    }

    public static LocalDate parseLocalDate(String date) {
        return date != null ? LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_FORMAT)) : null;
    }

    public static String formatLocalDate(LocalDate localDate) {
        return localDate != null ? localDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT)) : null;
    }
}

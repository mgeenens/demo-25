package com.example.demo25.utils;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static final String DATE_FORMAT = "dd/MM/yyyy";

    private DateUtils() {
    }

    public static LocalDate parseLocalDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_FORMAT));
    }

    public static String formatLocalDate(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }
}

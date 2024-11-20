package br.mattsousa.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {
    private static final DateTimeFormatter DEFAULT_DATE_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE; 
    public static int getSerialNumber() {
        return (int) (Math.random() * 1000000) + 99999;
    }

    public static boolean matchDateFormat(String date) {
        try {
            DEFAULT_DATE_FORMAT.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static LocalDate getLocalDate(String date) {
        return DEFAULT_DATE_FORMAT.parse(date).query(LocalDate::from);
    }
}

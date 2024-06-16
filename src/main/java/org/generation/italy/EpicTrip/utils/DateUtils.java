package org.generation.italy.EpicTrip.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtils {
    private static DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("yyyy MMM dd", Locale.ITALIAN);
    private static DateTimeFormatter isoFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateUtils(){}

    public static String format(LocalDate ld){
        return ld.format(isoFormatter);
    }
    public static LocalDate parse(String date){
        return LocalDate.parse(date, isoFormatter);
    }
}
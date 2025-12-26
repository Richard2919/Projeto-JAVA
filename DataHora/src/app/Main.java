package app;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDate d01 = LocalDate.now();
        System.out.println(d01);


        LocalDateTime d02 = LocalDateTime.now();
        System.out.println(d02);

        Instant d03 = Instant.now();
        System.out.println(d03);

        LocalDate d04 = LocalDate.parse("2026-01-20");
        System.out.println(d04);

        LocalDate pastWeekLocalDate = d01.minusDays(7);
        LocalDate nextWeekLocalDate = d01.plusDays(7);

    }
}
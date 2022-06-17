package kz.halykacademy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Введите строку в формате (yyyy-MM-dd):");
        String dateLiteral = new Scanner(System.in).nextLine();


        if (dateLiteral.matches("\\d{4}-\\d{2}-\\d{2}]")) {

            System.out.println("");
        }

        try {
            LocalDate date = LocalDate.parse(dateLiteral);
            System.out.println("Дата, которая будет через 30 дней: " + date.plusDays(30));
            System.out.println("Последнее воскресенье месяца: " + date.with(
                    TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY)
            ));

            System.out.println(
                    "До Нового Года осталось " +
                            ChronoUnit.DAYS.between(date, LocalDate.parse(date.getYear() + "-12-31"))
                            + " дней"
            );

        } catch (DateTimeParseException e) {
            System.out.println("Формат не поддерживается");
        }

    }
}

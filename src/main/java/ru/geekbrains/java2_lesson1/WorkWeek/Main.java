package ru.geekbrains.java2_lesson1.WorkWeek;

public class Main {
    public static void main(String[] args) {
        int sumWorkingHours = 0;

        DayOfWeek day = DayOfWeek.THURSDAY;
        DayOfWeek[] week = DayOfWeek.values();

        if (day.getDayType().equals(DayType.WORK_DAY)) {
             for (int i = day.ordinal(); i < week.length; i++) {
                sumWorkingHours += week[i].getWorkingHours();
             }
             System.out.println(sumWorkingHours);
         }
         else {
             System.out.println("Сегодня выходной!");
         }
    }
}

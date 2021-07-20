package ru.geekbrains.java2_lesson1.WorkWeek;

public enum DayOfWeek {
    MONDAY (DayType.WORK_DAY, 9),
    TUESDAY (DayType.WORK_DAY, 9),
    WEDNESDAY (DayType.WORK_DAY, 9),
    THURSDAY (DayType.WORK_DAY, 9),
    FRIDAY (DayType.WORK_DAY, 8),
    SATURDAY (DayType.FREE_DAY, 0),
    SUNDAY (DayType.FREE_DAY, 0);

   private final DayType dayType;
   private final int workingHours;


    DayOfWeek(DayType dayType, int workingHours) {
        this.dayType = dayType;
        this.workingHours = workingHours;
    }

    public DayType getDayType() {
        return dayType;
    }


    public int getWorkingHours() {
        return workingHours;
    }


}

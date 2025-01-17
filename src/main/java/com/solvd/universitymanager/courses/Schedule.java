package com.solvd.universitymanager.courses;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Schedule {

    private final WeekDay weekDay;
    private final Course course;
    private LocalDateTime dateTime;

    public Schedule(Course course, LocalDateTime dateTime) {
        this.course = course;
        this.dateTime = dateTime;
        this.weekDay = mapToWeekDay(dateTime.getDayOfWeek());
    }

    private WeekDay mapToWeekDay(DayOfWeek dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY -> WeekDay.MONDAY;
            case TUESDAY -> WeekDay.TUESDAY;
            case WEDNESDAY -> WeekDay.WEDNESDAY;
            case THURSDAY -> WeekDay.THURSDAY;
            case FRIDAY -> WeekDay.FRIDAY;
            case SATURDAY -> WeekDay.SATURDAY;
            case SUNDAY -> WeekDay.SUNDAY;
        };
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public Course getCourse() {
        return course;
    }

    public void updateSchedule(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Schedule information: " + "\n"
                + "Date and time: " + dateTime + ", " + weekDay + "\n"
                + "Course: " + course;
    }
}

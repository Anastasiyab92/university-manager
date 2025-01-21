package com.solvd.universitymanager.courses;

import java.time.LocalDateTime;

public class Schedule {

    private Long id;
    private WeekDay weekDay;
    private LocalDateTime dateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay =
                switch (weekDay) {
                    case MONDAY -> WeekDay.MONDAY;
                    case TUESDAY -> WeekDay.TUESDAY;
                    case WEDNESDAY -> WeekDay.WEDNESDAY;
                    case THURSDAY -> WeekDay.THURSDAY;
                    case FRIDAY -> WeekDay.FRIDAY;
                    case SATURDAY -> WeekDay.SATURDAY;
                    case SUNDAY -> WeekDay.SUNDAY;
                };
    }

    @Override
    public String toString() {
        return "Schedule information: " + "\n"
                + "Date and time: " + dateTime + ", " + weekDay;
    }
}

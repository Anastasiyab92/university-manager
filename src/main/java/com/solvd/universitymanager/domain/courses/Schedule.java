package com.solvd.universitymanager.domain.courses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.universitymanager.parser.LocalDateTimeAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDateTime;

@XmlAccessorType(XmlAccessType.FIELD)
public class Schedule {
    @JsonIgnore
    private Long id;

    @XmlElement(name = "weekDay")
    @JsonProperty("weekDay")
    private WeekDay weekDay;

    @XmlElement(name = "dateTime")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @JsonProperty("dateTime")
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

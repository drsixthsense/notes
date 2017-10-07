package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String text;

    private boolean done;

    private Date date;

    public Notes() {
    }

    public Notes(String text) {
        this.text = text;
    }

    public Notes(String text, boolean done, Date date) {
        this.text = text;
        this.done = done;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void toggleDone() {
        setDone(!isDone());
    }

    public LocalDateTime getDate() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = instant.atZone(defaultZoneId).toLocalDateTime();
        return localDateTime;
    }

    public void setDate(LocalDateTime date) {
        Date out = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
        this.date = out;
    }

    public Date getDateForCompare(){
        return date;
    }
}

package com.example.roomhomework.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "homework")
public class HomeWorkEntity {

    @PrimaryKey(autoGenerate = true)
    private int homeworkId;

    @ColumnInfo(name = "homework_subject")
    private String homeworkSubject;

    @ColumnInfo(name = "homework_week")
    private int homeworkWeek;

    @ColumnInfo(name = "homework_day")
    private int homeworkDay;

    @ColumnInfo(name = "homework_complete")
    private boolean isHomeworkComplete;

    public HomeWorkEntity(int homeworkId, String homeworkSubject, int homeworkWeek, int homeworkDay, boolean isHomeworkComplete) {
        this.homeworkId = homeworkId;
        this.homeworkSubject = homeworkSubject;
        this.homeworkWeek = homeworkWeek;
        this.homeworkDay = homeworkDay;
        this.isHomeworkComplete = isHomeworkComplete;
    }

    @Ignore
    public HomeWorkEntity(String homeworkSubject, int homeworkWeek, int homeworkDay, boolean isHomeworkComplete) {
        this.homeworkSubject = homeworkSubject;
        this.homeworkWeek = homeworkWeek;
        this.homeworkDay = homeworkDay;
        this.isHomeworkComplete = isHomeworkComplete;
    }

    public int getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getHomeworkSubject() {
        return homeworkSubject;
    }

    public void setHomeworkSubject(String homeworkSubject) {
        this.homeworkSubject = homeworkSubject;
    }

    public int getHomeworkWeek() {
        return homeworkWeek;
    }

    public void setHomeworkWeek(int homeworkWeek) {
        this.homeworkWeek = homeworkWeek;
    }

    public int getHomeworkDay() {
        return homeworkDay;
    }

    public void setHomeworkDay(int homeworkDay) {
        this.homeworkDay = homeworkDay;
    }

    public boolean isHomeworkComplete() {
        return isHomeworkComplete;
    }

    public void setHomeworkComplete(boolean homeworkComplete) {
        isHomeworkComplete = homeworkComplete;
    }
}

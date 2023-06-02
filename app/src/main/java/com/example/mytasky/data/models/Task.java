package com.example.mytasky.data.models;

import com.prolificinteractive.materialcalendarview.CalendarDay;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Task {
    private String taskText;
    private CalendarDay date;

    private LocalDateTime expirationDate;

    public Task(String taskText, CalendarDay date, LocalDateTime expirationDate) {
        this.taskText = taskText;
        this.date = date;
        this.expirationDate = expirationDate;
    }

    public String getTaskText() {
        return taskText;
    }

    public CalendarDay getDate() {
        return date;
    }
    public LocalDateTime getExpirationDate() { return expirationDate;}

    public void setTaskText(String taskText) {
        this.taskText  = taskText;
    }
    public void setDate (CalendarDay date) {
        this.date  = date;
    }
    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isDueSoon() {
        LocalDateTime now = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            now = LocalDateTime.now();

            LocalDateTime dueDate = getExpirationDate();
            long hoursDifference = 0;
            hoursDifference = ChronoUnit.HOURS.between(now, dueDate);
            return hoursDifference <= 2;
        }
        else {
            return false;
        }
    }
}

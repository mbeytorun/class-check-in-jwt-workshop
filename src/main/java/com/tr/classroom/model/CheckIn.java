package com.tr.classroom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class CheckIn {

    @Id
    @GeneratedValue
    private Long id;
    private Long studentId;
    private Long classId;
    private Long activityId;
    private LocalDate date;

    public CheckIn() {

    }

    public CheckIn(Long classId, Long activityId, Long studentId, LocalDate date) {
        this.classId = classId;
        this.activityId = activityId;
        this.studentId = studentId;
        this.date = date;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}

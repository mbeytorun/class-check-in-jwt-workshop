package com.tr.classroom.services;

import com.tr.classroom.model.Activity;
import com.tr.classroom.model.CheckIn;
import com.tr.classroom.model.ClassRoom;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ClassService {

    List<ClassRoom> getClasses();

    List<Activity> getActivities(Long classId);

    CheckIn checkIn(Long classId, Long activityId, Long studentId);
    // To prevent QR code abuse geocodes can be used:
    // CheckIn checkIn(Long classId, Long activityId, Long studentId, Long latitude, Long longitude);

    List<CheckIn> listCheckIn();
}

package com.tr.classroom.webservices;

import com.tr.classroom.model.Activity;
import com.tr.classroom.model.CheckIn;
import com.tr.classroom.model.ClassRoom;
import com.tr.classroom.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ClassRestService {

    @Autowired
    private ClassService classService;

    @GetMapping(value="/class-activities/{classId}")
    public List<Activity> getActivities(@PathVariable Long classId) {
        return classService.getActivities(classId);
    }

    // To prevent QR code abuse geocodes can be used:
    // CheckIn checkIn(Long classId, Long activityId, Long studentId, Long latitude, Long longitude);
    @PostMapping("/check-in/{classId},{activityId},{studentId}")
    public CheckIn checkIn(@PathVariable Long classId, @PathVariable Long activityId, @PathVariable Long studentId) {
        return classService.checkIn(classId, activityId, studentId);
    }

    @GetMapping(value="/classes")
    public List<ClassRoom> getClasses() {
        return classService.getClasses();
    }

    @GetMapping(value="/list-check-in")
    public List<CheckIn> listCheckIn() {
        return classService.listCheckIn();
    }

}

package com.tr.classroom.services.impl;

import com.tr.classroom.dao.ActivityRepository;
import com.tr.classroom.dao.CheckInRepository;
import com.tr.classroom.dao.ClassRepository;
import com.tr.classroom.exception.ClassException;
import com.tr.classroom.model.Activity;
import com.tr.classroom.model.CheckIn;
import com.tr.classroom.model.ClassRoom;
import com.tr.classroom.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private CheckInRepository checkInRepository;

    @Override
    public List<ClassRoom> getClasses() {
        return classRepository.findAll();
    }

    @Override
    public List<Activity> getActivities(Long classId) {
        List<Activity> activities = activityRepository.getAvailableActivities(classId);
        return Optional.of(activities).orElseThrow(() -> new ClassException("No Activity Found For Class"));
    }

    @Override
    public CheckIn checkIn(Long classId, Long activityId, Long studentId) {
        CheckIn checkIn = new CheckIn();
        checkIn.setDate(LocalDate.now());
        checkIn.setStudentId(studentId);
        checkIn.setClassId(classId);
        checkIn.setActivityId(activityId);
        return checkInRepository.save(checkIn);
    }

    @Override
    public List<CheckIn> listCheckIn() {
        return checkInRepository.findAll();
    }
}

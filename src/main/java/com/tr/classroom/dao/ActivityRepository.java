package com.tr.classroom.dao;

import com.tr.classroom.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query("SELECT a FROM Activity a WHERE a.classRoom.id = :classId and " +
            "a.startDateTime > CURRENT_TIMESTAMP and a.endDateTime> CURRENT_TIMESTAMP")
    List<Activity> getAvailableActivities(@Param("classId") Long classId);
}

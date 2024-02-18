package com.tr.classroom.dao;

import com.tr.classroom.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassRoom, Long> {
}

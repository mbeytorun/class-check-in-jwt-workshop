package com.tr.classroom;

import com.tr.classroom.dao.ActivityRepository;
import com.tr.classroom.dao.CheckInRepository;
import com.tr.classroom.dao.ClassRepository;
import com.tr.classroom.model.Activity;
import com.tr.classroom.model.CheckIn;
import com.tr.classroom.model.ClassRoom;
import com.tr.classroom.services.ClassService;
import com.tr.classroom.services.impl.ClassServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassServiceTest {

    @Mock
    ClassRepository classRepository;

    @Mock
    ActivityRepository activityRepository;

    @Mock
    CheckInRepository checkInRepository;

    @InjectMocks
    ClassService classService = new ClassServiceImpl();

    @Test
    public void testGetClasses() {

        ClassRoom classRoom1 = new ClassRoom(100L, "Blue", "32.454352", "26.38686");
        ClassRoom classRoom2 = new ClassRoom(101L, "Yellow", "32.454352", "26.38686");

        classRepository.save(classRoom1);
        classRepository.save(classRoom2);

        List<ClassRoom> classes = classService.getClasses();
        assertThat(classes.size() == 2);
    }

    @Test
    public void testGetActivities() {
        ClassRoom classRoom1 = new ClassRoom(300L, "Blue", "32.454352", "26.38686");
        Activity activity1 = new Activity(1001L, "Maths",
                LocalDateTime.of(2021, Month.MAY, 29, 8,30, 0),
                LocalDateTime.of(2021, Month.MAY, 29, 9,30, 0));
        activity1.setClassRoom(classRoom1);

        Activity activity2 = new Activity(5555L, "Maths",
                LocalDateTime.of(2021, Month.MAY, 21, 8,30, 0),
                LocalDateTime.of(2021, Month.MAY, 21, 9,30, 0));
        activity2.setClassRoom(classRoom1);

        Set<Activity> activitySet = new HashSet<>();
        activitySet.add(activity1);
        activitySet.add(activity2);
        classRoom1.setActivities(activitySet);

        classRepository.save(classRoom1);
        List<Activity> activities = classService.getActivities(100L);
        assertThat(activities.size() == 1);
        assertThat(activities.get(0).getDescription().equals("Blue"));
    }

    @Test
    public void testCheckIn() {
        CheckIn checkIn = new CheckIn();
        checkIn.setDate(LocalDate.now());
        checkIn.setStudentId(123L);
        checkIn.setClassId(120L);
        checkIn.setActivityId(5010L);
        CheckIn checkInResult = checkInRepository.save(checkIn);

        assertEquals(Long.valueOf(5010), checkInResult.getActivityId());
    }

    @Test
    public void listCheckIn() {
        CheckIn checkIn = new CheckIn();
        checkIn.setDate(LocalDate.now());
        checkIn.setStudentId(123L);
        checkIn.setClassId(120L);
        checkIn.setActivityId(5010L);
        checkInRepository.save(checkIn);

        CheckIn checkIn2 = new CheckIn();
        checkIn2.setDate(LocalDate.now());
        checkIn2.setStudentId(125L);
        checkIn2.setClassId(122L);
        checkIn2.setActivityId(5020L);
        checkInRepository.save(checkIn);

        List<CheckIn> checkInList = classService.listCheckIn();
        assertThat(checkInList.size() == 2);
    }
}

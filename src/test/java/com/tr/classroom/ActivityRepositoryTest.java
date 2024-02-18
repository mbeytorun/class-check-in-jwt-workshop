package com.tr.classroom;

import com.tr.classroom.dao.ActivityRepository;
import com.tr.classroom.model.Activity;
import com.tr.classroom.model.ClassRoom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ActivityRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ActivityRepository activityRepository;

    @Test
    public void testGetActivities() {

        ClassRoom classRoom1 = new ClassRoom(102L, "Blue", "32.454352", "26.38686");
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

        entityManager.persist(classRoom1);


        List<Activity> activities = activityRepository.getAvailableActivities(102L);
        assertEquals(0, activities.size());
        assertEquals("Maths", activities.get(0).getDescription());

    }

}

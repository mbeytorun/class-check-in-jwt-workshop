package com.tr.classroom;

import com.tr.classroom.dao.CheckInRepository;
import com.tr.classroom.model.CheckIn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CheckInRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CheckInRepository checkInRepository;

    @Test
    public void testCheckIn() {
        entityManager.persist(new CheckIn(100L, 2001L, 34506L, LocalDate.now()));

        CheckIn checkIn = checkInRepository.getById(1L);
        assertEquals(Long.valueOf(2001), checkIn.getActivityId());
    }
}

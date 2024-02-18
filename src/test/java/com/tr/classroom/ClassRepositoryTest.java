package com.tr.classroom;

import com.tr.classroom.dao.ClassRepository;
import com.tr.classroom.model.ClassRoom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClassRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ClassRepository classRepository;

    @Test
    public void testFindByName() {

        entityManager.persist(new ClassRoom(100L, "Blue", "32.454352", "26.38686"));

        ClassRoom classRoom = classRepository.findById(100L).get();
        assertEquals("Blue", classRoom.getDescription());

    }

}

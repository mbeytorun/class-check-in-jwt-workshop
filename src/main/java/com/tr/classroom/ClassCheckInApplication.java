package com.tr.classroom;

import com.tr.classroom.dao.ClassRepository;
import com.tr.classroom.model.Activity;
import com.tr.classroom.model.ClassRoom;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ClassCheckInApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassCheckInApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(ClassRepository repository) {
		return args -> {

			ClassRoom classRoom1 = new ClassRoom(100L, "Blue", "32.454352", "26.38686");

			Activity activity1 = new Activity(1001L, "Maths",
					LocalDateTime.of(2021, Month.MAY, 29, 8,30, 0),
					LocalDateTime.of(2021, Month.MAY, 29, 9,30, 0));
			activity1.setClassRoom(classRoom1);

			Activity activity0 = new Activity(5555L, "Maths",
					LocalDateTime.of(2021, Month.MAY, 21, 8,30, 0),
					LocalDateTime.of(2021, Month.MAY, 21, 9,30, 0));
			activity0.setClassRoom(classRoom1);

			Activity activity2  = new Activity(2001L, "Science",
					LocalDateTime.of(2021, Month.MAY, 29, 10,30, 0),
					LocalDateTime.of(2021, Month.MAY, 29, 11,30, 0));
			activity2.setClassRoom(classRoom1);

			Activity activity3  = new Activity(3001L, "Music",
					LocalDateTime.of(2021, Month.MAY, 29, 13,30, 0),
					LocalDateTime.of(2021, Month.MAY, 29, 14,30, 0));
			activity3.setClassRoom(classRoom1);

			Set<Activity> activitySet = new HashSet<>();
			activitySet.add(activity1);
			activitySet.add(activity2);
			activitySet.add(activity3);
			activitySet.add(activity0);
			classRoom1.setActivities(activitySet);

			repository.save(classRoom1);


			ClassRoom classRoom2 = new ClassRoom(200L, "Yellow", "32.454352", "26.38686");

			Activity activity4 = new Activity(1002L, "Maths",
					LocalDateTime.of(2021, Month.MAY, 29, 8,30, 0),
					LocalDateTime.of(2021, Month.MAY, 29, 9,30, 0));
			activity4.setClassRoom(classRoom2);

			Activity activity5  = new Activity(2002L, "Science",
					LocalDateTime.of(2021, Month.MAY, 29, 10,30, 0),
					LocalDateTime.of(2021, Month.MAY, 29, 11,30, 0));
			activity5.setClassRoom(classRoom2);

			Activity activity6  = new Activity(3002L, "Music",
					LocalDateTime.of(2021, Month.MAY, 29, 13,30, 0),
					LocalDateTime.of(2021, Month.MAY, 29, 14,30, 0));
			activity6.setClassRoom(classRoom2);

			Set<Activity> activitySet2 = new HashSet<>();
			activitySet2.add(activity4);
			activitySet2.add(activity5);
			activitySet2.add(activity6);
			classRoom2.setActivities(activitySet2);

			repository.save(classRoom2);

		};
	}

}

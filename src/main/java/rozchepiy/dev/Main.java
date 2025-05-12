package rozchepiy.dev;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rozchepiy.dev.services.ProfileService;
import rozchepiy.dev.services.StudentService;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("rozchepiy.dev");
        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        StudentService studentService = context.getBean(StudentService.class);
        ProfileService profileService = context.getBean(ProfileService.class);


        Student student1 = new Student("Vasya", 22);
        Student student2 = new Student("Petya", 23);

        studentService.saveStudent(student1);
        studentService.saveStudent(student2);

        Profile profile1 = new Profile("My bio", LocalDateTime.now(), student1);

        profileService.saveProfile(profile1);

    }
}
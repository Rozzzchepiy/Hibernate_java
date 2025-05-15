package rozchepiy.dev;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rozchepiy.dev.model.Student;
import rozchepiy.dev.services.CourseService;
import rozchepiy.dev.services.GroupService;
import rozchepiy.dev.services.ProfileService;
import rozchepiy.dev.services.StudentService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("rozchepiy.dev");
        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        StudentService studentService = context.getBean(StudentService.class);
        ProfileService profileService = context.getBean(ProfileService.class);
        GroupService groupService = context.getBean(GroupService.class);
        CourseService courseService = context.getBean(CourseService.class);


//        Group group1 = groupService.saveGroup("1", 2024L);
//        Group group2 = groupService.saveGroup("2", 2024L);
//        Group group3 = groupService.saveGroup("3", 2024L);
//
//        Student student1 = new Student("Vasya", 22, group1);
//        Student student2 = new Student("Petya", 23, group1);
//
//        studentService.saveStudent(student1);
//        studentService.saveStudent(student2);
//
//        Course course1 = new Course("Java", "Programming");
//        Course course2 = new Course("Spring", "Programming");
//        Course course3 = new Course("Hibernate", "Programming");
//
//        courseService.saveCourse(course1);
//        courseService.saveCourse(course2);
//        courseService.saveCourse(course3);

        courseService.enrollStudentToCourse(2L, 1L);
        Student student = studentService.getById(1L);
        System.out.println(student);
    }
}
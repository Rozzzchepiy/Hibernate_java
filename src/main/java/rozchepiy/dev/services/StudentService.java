package rozchepiy.dev.services;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import rozchepiy.dev.Student;

import java.util.List;

@Service
public class StudentService {

    private final SessionFactory sessionFactory;

    public StudentService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Student saveStudent(Student student){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
        session.close();
        return student;
    }

    public void deleteStudent(Long id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student studentForDelete = session.get(Student.class, id);
        session.remove(studentForDelete);
        session.getTransaction().commit();
        session.close();
    }

    public Student getById(Long id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();
        session.close();
        return student;
    }

    public List<Student> findAllStudents(){
        Session session = sessionFactory.openSession();
        List<Student> AllStudents = session.createQuery("SELECT s FROM Student s", Student.class).list();
        session.close();
        return AllStudents;
    }

    public Student updateStudent(Student student){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        student = session.merge(student);
        session.getTransaction().commit();
        session.close();
        return student;
    }
}

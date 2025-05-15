package rozchepiy.dev.services;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import rozchepiy.dev.model.Student;
import rozchepiy.dev.util.TransactionHelper;


import java.util.List;

@Service
public class StudentService {

    private final SessionFactory sessionFactory;
    private final TransactionHelper transactionHelper;

    public StudentService(SessionFactory sessionFactory, TransactionHelper transactionHelper) {
        this.sessionFactory = sessionFactory;
        this.transactionHelper = transactionHelper;
    }

    public Student saveStudent(Student student) {
        return transactionHelper.executeInTransaction(session -> {
            session.persist(student);
            return student;
        });
    }

    public void deleteStudent(Long id) {
       transactionHelper.executeInTransaction(session -> {
           Student studentForDelete = session.get(Student.class, id);
           session.remove(studentForDelete);
       });
    }

    public Student getById(Long id) {
        try( Session session = sessionFactory.openSession()){
            return session.get(Student.class, id);
        }
    }

    public List<Student> findAllStudents() {
        try( Session session = sessionFactory.openSession()){
            return session.createQuery("SELECT s FROM Student s", Student.class).list();
        }
    }

    public Student updateStudent(Student student) {
        return transactionHelper.executeInTransaction(session -> {
            return session.merge(student);
        });
    }
}

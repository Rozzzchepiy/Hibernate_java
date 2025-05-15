package rozchepiy.dev.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import rozchepiy.dev.model.Group;
import rozchepiy.dev.util.TransactionHelper;

import java.util.List;

@Service
public class GroupService {
    private final SessionFactory sessionFactory;
    private final TransactionHelper transactionHelper;

    public GroupService(SessionFactory sessionFactory, TransactionHelper transactionHelper) {
        this.sessionFactory = sessionFactory;
        this.transactionHelper = transactionHelper;
    }

    public Group saveGroup(String number, Long gradYear){
            return transactionHelper.executeInTransaction(session -> {
                var group = new Group(number, gradYear);
                session.persist(group);
                return group;
            });
    }

    public List<Group> findAllGroups(){
        try( Session session = sessionFactory.openSession()){
            return session.createQuery("SELECT g FROM Group g left join fetch g.studentList s left join fetch s.profile", Group.class ).list();
        }
    }
}

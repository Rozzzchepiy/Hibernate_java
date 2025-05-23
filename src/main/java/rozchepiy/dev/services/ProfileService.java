package rozchepiy.dev.services;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import rozchepiy.dev.model.Profile;
import rozchepiy.dev.util.TransactionHelper;

@Service
public class ProfileService {

    private final SessionFactory sessionFactory;
    private final TransactionHelper transactionHelper;

    public ProfileService(SessionFactory sessionFactory, TransactionHelper transactionHelper) {
        this.sessionFactory = sessionFactory;
        this.transactionHelper = transactionHelper;
    }

    public Profile saveProfile(Profile profile){
        return transactionHelper.executeInTransaction(session -> {
            session.persist(profile.getStudent());
            return profile;
        });
    }
}

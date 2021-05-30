package Pract_16;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.UUID;

@Service
public class NewBank {
    @Autowired
    private final SessionFactory sessionFactory;

    public NewBank(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session session;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    @PreDestroy
    public void unSession() {
        session.close();
    }

    public void addBank(Bank bank) {
        session.beginTransaction();
        session.saveOrUpdate(bank);
        session.getTransaction().commit();
    }

    public List<Bank> getBanks() {
        return session.createQuery("select u from Bank u", Bank.class).list();
    }


    public void delete(UUID id) {
        session.beginTransaction();

        Bank temp = session.load(Bank.class, id);
        session.delete(temp);

        session.getTransaction().commit();
    }
}

package Pract_17;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    private CriteriaBuilder builder;
    private CriteriaQuery<Bank> bankCriteriaQuery;
    private Root<Bank> root;

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
        builder = session.getCriteriaBuilder();
        bankCriteriaQuery = builder.createQuery(Bank.class);
        root = bankCriteriaQuery.from(Bank.class);
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

    public List<Bank> filterByName() {
        bankCriteriaQuery.select(root).orderBy(builder.asc(root.get("name")));
        Query<Bank> query = session.createQuery(bankCriteriaQuery);
        return query.getResultList();
    }

    public List<Bank> filterByAddress() {
        bankCriteriaQuery.select(root).orderBy(builder.asc(root.get("address")));
        Query<Bank> query = session.createQuery(bankCriteriaQuery);
        return query.getResultList();
    }
}

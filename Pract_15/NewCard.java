package Pract_15;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.UUID;

@Service
public class NewCard {
    @Autowired
    private final SessionFactory sessionFactory;

    public NewCard(SessionFactory sessionFactory) {
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

    public void addCard(Card card) {
        session.beginTransaction();
        session.saveOrUpdate(card);
        session.getTransaction().commit();
    }

    public List<Card> getCards() {
        return session.createQuery("select u from Card u", Card.class).list();
    }


    public void deleteManufacture(UUID id) {
        session.beginTransaction();

        Card temp = session.load(Card.class, id);
        session.delete(temp);

        session.getTransaction().commit();
    }
}

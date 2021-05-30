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
public class NewCard {
    @Autowired
    private final SessionFactory sessionFactory;

    public NewCard(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session session;
    private CriteriaBuilder builder;
    private CriteriaQuery<Card> cardCriteriaQuery;
    private Root<Card> root;

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
        builder = session.getCriteriaBuilder();
        cardCriteriaQuery = builder.createQuery(Card.class);
        root = cardCriteriaQuery.from(Card.class);
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

    public List<Card> filterByCardNumber() {
        cardCriteriaQuery.select(root).orderBy(builder.asc(root.get("cardNumber")));
        Query<Card> query = session.createQuery(cardCriteriaQuery);
        return query.getResultList();
    }

    public List<Card> filterByCode() {
        cardCriteriaQuery.select(root).orderBy(builder.asc(root.get("code")));
        Query<Card> query = session.createQuery(cardCriteriaQuery);
        return query.getResultList();
    }
}

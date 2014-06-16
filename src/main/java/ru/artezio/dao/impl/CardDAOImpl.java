package ru.artezio.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.artezio.dao.CardDAO;
import ru.artezio.entity.Card;

import java.util.List;

@Repository
public class CardDAOImpl implements CardDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Card load(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (Card) session.get(Card.class, id);
    }

    @Override
    public void save(Card c) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(c);
    }

    @Override
    public void remove(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(id);
    }

    @Override
    public List<Card> loadAll() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Card>)session.createCriteria(Card.class).list();
    }
}

package ru.artezio.dao.impl;

import ru.artezio.dao.CardDAO;
import ru.artezio.entity.node.Card;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CardDAOImpl implements CardDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Card load(Integer id) {
        return em.find(Card.class, id);
    }

    @Override
    public void save(Card card) {
        em.merge(card);
    }

    @Override
    public void remove(Integer id) {
        Card card = em.find(Card.class, id);
        if (card != null) {
            em.remove(card);
        }
    }

    @Override
    public List<Card> loadCardsByFolder(Integer id, String login) {
        String sqlQuery = "select * from nodes where login = ? and folder_id = ? and type = 'Card'";
        Query q = em.createNativeQuery(sqlQuery, Card.class);
        q.setParameter(1, login);
        q.setParameter(2, id);
        return (List<Card>) q.getResultList();
    }
}

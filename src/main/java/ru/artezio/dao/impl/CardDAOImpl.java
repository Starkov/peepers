package ru.artezio.dao.impl;

import ru.artezio.dao.CardDAO;
import ru.artezio.entity.Card;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class CardDAOImpl implements CardDAO {

    @PersistenceContext(name = "card-unit")
    private EntityManager em;

    @Override
    public Card load(Integer id) {
        return em.find(Card.class, id);
    }

    @Override
    public void save(Card c) {
        em.merge(c);
    }

    @Override
    public void remove(Integer id) {
        Card c = em.find(Card.class, id);
        if (c != null) {
            em.remove(c);
        }
    }

    @Override
    public List<Card> loadAll() {
        Query query = em.createQuery("SELECT c FROM Card c");
        return (List<Card>) query.getResultList();
    }
}

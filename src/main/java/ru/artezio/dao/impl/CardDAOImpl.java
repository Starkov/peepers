package ru.artezio.dao.impl;

import ru.artezio.dao.CardDAO;
import ru.artezio.entity.node.Card;
import ru.artezio.entity.node.Node;

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
    public Node load(Integer id) {
        return em.find(Card.class, id);
    }

    @Override
    public void save(Node c) {
        em.persist(c);
        em.flush();
    }

    @Override
    public void remove(Integer id) {
        Card c = em.find(Card.class, id);
        if (c != null) {
            em.remove(c);
        }
    }

    @Override
    public List<Node> loadAll() {
        Query query = em.createQuery("SELECT c FROM Card c");
        return (List<Node>) query.getResultList();
    }

    @Override
    public List<Node> loadAll(String login) {
        Query query = em.createQuery("SELECT c FROM Card c WHERE c.login = :login");
        query.setParameter("login",login);
        return (List<Node>) query.getResultList();
    }
}

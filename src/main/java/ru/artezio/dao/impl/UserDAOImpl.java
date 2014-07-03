package ru.artezio.dao.impl;

import ru.artezio.dao.UserDAO;
import ru.artezio.entity.node.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by astarkov on 30.06.2014.
 */
@Stateless
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User load(String id) {
        return em.find(User.class, id);
    }

    @Override
    public void save(User u) {
        em.merge(u);
    }

    @Override
    public void remove(String id) {
        User u = em.find(User.class, id);
        if (u != null) {
            em.remove(u);
        }
    }

    @Override
    public List<User> loadAll() {
        Query query = em.createQuery("SELECT u FROM User u");
        return (List<User>) query.getResultList();
    }


}

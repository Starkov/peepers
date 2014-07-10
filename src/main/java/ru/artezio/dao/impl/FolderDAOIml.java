package ru.artezio.dao.impl;

import ru.artezio.dao.FolderDAO;
import ru.artezio.entity.node.Folder;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class FolderDAOIml implements FolderDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Folder load(Integer id) {
        return em.find(Folder.class, id);
    }

    @Override
    public void save(Folder folder) {
        em.merge(folder);
    }

    @Override
    public void remove(Integer id) {
        Folder folder = em.find(Folder.class, id);
        if (folder != null) {
            em.remove(folder);
        }
    }

    @Override
    public List<Folder> loadRootFoldersBy(String login) {
        Query query = em.createQuery("SELECT e FROM Folder e WHERE e.login = :login and e.folder is null");
        query.setParameter("login", login);
        return (List<Folder>) query.getResultList();
    }

    @Override
    public List<Folder> loadFoldersBy(String login) {
        Query query = em.createQuery("SELECT e FROM Folder e WHERE e.login = :login");
        query.setParameter("login", login);
        return (List<Folder>) query.getResultList();
    }
}

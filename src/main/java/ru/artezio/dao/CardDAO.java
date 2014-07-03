package ru.artezio.dao;

import ru.artezio.entity.node.Card;
import ru.artezio.entity.node.Node;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by astarkov on 30.06.2014.
 */
@Transactional
public interface CardDAO {
    Node load(Integer id);
    void save(Node n);
    void remove(Integer id);
    List<Node> loadAll();

    /**
     * Return all nodes for the user by login
     *
     * @param login Login a user
     * @return All nodes for the user
     */
    List<Node> loadAll(String login);
}

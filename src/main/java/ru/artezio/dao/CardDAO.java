package ru.artezio.dao;

import ru.artezio.entity.node.Card;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by astarkov on 30.06.2014.
 */
@Transactional
public interface CardDAO {
    /**
     * This is load a Card by id
     *
     * @param id Card
     * @return a Card by id
     */
    Card load(Integer id);

    /**
     * This is save a Card
     *
     * @param card
     */
    void save(Card card);

    /**
     * This is remove a Card by id
     *
     * @param id a Card
     */
    void remove(Integer id);

    /**
     * This is get a list cards in the folder of user
     *
     * @param id    the folder
     * @param login the user
     * @return List cards in the folder of user
     */
    List<Card> loadCardsByFolder(Integer id, String login);

}

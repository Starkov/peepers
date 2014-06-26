package ru.artezio.dao;


import ru.artezio.entity.Card;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CardDAO {
    Card load(Integer id);
    void save(Card c);
    void remove(Integer id);
    List<Card> loadAll();
}

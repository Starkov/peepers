package ru.artezio.dao;

import org.springframework.transaction.annotation.Transactional;
import ru.artezio.entity.Card;

import java.util.List;

@Transactional
public interface CardDAO {
    Card load(Integer id);
    void save(Card c);
    void remove(Integer id);
    List<Card> loadAll();
}

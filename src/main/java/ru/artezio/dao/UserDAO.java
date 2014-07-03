package ru.artezio.dao;


import ru.artezio.entity.node.User;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserDAO {
    User load(String id);

    void save(User u);

    void remove(String id);

    List<User> loadAll();
}

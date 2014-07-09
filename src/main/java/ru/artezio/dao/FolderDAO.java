package ru.artezio.dao;

import ru.artezio.entity.node.Folder;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface FolderDAO {

    /**
     * This is load a folder by id
     *
     * @param id the folder
     * @return the Folder
     */
    Folder load(Integer id);

    /**
     * This is save a folder
     *
     * @param folder
     */
    void save(Folder folder);

    /**
     * This is remove the folder by id
     *
     * @param id
     */
    void remove(Integer id);

    /**
     * Thi is load a list folders by the user
     *
     * @param login the user
     * @return list folders by the user
     */
    List<Folder> loadFoldersBy(String login);
}

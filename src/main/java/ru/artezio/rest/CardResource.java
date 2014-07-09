package ru.artezio.rest;


import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;
import ru.artezio.dao.CardDAO;
import ru.artezio.dao.FolderDAO;
import ru.artezio.entity.node.Card;
import ru.artezio.entity.node.Folder;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by astarkov on 13.06.2014.
 */

@ApplicationScoped
@Path("/cards")
public class CardResource {

    @EJB
    private CardDAO nodeDao;
    @EJB
    private FolderDAO folderDAO;

    @POST
    @Path("/add")
    @BadgerFish
    @Consumes("application/json")
    public void add(Card card) {
        card.setLogin("tomcat"); //todo Keep this to a user
        Folder parentFolder = (Folder) folderDAO.load(card.getParentHolderId());
        card.setParentFolder(parentFolder);
        nodeDao.save(card);
    }
    @GET
    @Path("/{id:\\d+}")
    @Produces("application/json")
    public Card getById(@PathParam("id") Integer id) {
        return (Card) nodeDao.load(id);
    }

    @DELETE
    @Path("/remove/{id:\\d+}")
    public void remove(@PathParam("id") Integer id) {
        nodeDao.remove(id);
    }


    @GET
    @Path("/all/folder/{id:\\d+}")
    @BadgerFish
    @Produces("application/json")
    public List getCardsByFolder(@PathParam("id") Integer id) {
        List result = nodeDao.loadCardsByFolder(id, "tomcat");
        return result;
    }




}

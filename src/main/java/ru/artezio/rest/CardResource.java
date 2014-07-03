package ru.artezio.rest;


import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;
import ru.artezio.dao.CardDAO;
import ru.artezio.dao.UserDAO;
import ru.artezio.entity.node.Card;

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
    private UserDAO userDAO;

    /**
     * This method is save or update an object
     */
    @POST
    @Path("/add")
    @Consumes("application/json")
    public void add(Card card) {
        // card.setLogin("tomcat"); //todo Keep this to a user
        nodeDao.save(card);
    }

    @BadgerFish
    @GET
    @Path("/all")
    @Produces("application/json")
    public List getAll() {
        List result = nodeDao.loadAll("tomcat");
        return result;
    }

    @BadgerFish
    @GET
    @Path("/tree")
    @Produces("application/json")
    public List getCardTree() {
        List result = nodeDao.loadCardTreeBy("tomcat");
        return result;
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

}

package ru.artezio.rest;


import ru.artezio.dao.CardDAO;
import ru.artezio.entity.Card;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by astarkov on 13.06.2014.
 */

@ApplicationScoped
@Path("/cards")

public class CardResource {

    @EJB
    private CardDAO dao;

    /**
     * This method is save or update an object
     */
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Card card) {
        card.setUser("tomcat"); //todo Keep this to a user
        dao.save(card);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Card>  getAll() {

        List<Card> result = dao.loadAll();
        return result;
    }


    @GET
    @Path("/{id:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Card getById(@PathParam("id") Integer id) {
        return dao.load(id);
    }

    @DELETE
    @Path("/remove/{id:\\d+}")
    public void remove(@PathParam("id") Integer id) {
        dao.remove(id);
    }

}

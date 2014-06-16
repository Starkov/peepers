package ru.artezio.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.artezio.CardMock;
import ru.artezio.dao.CardDAO;
import ru.artezio.entity.Card;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by astarkov on 13.06.2014.
 */

@Component
@Scope("prototype")
@Path("/cards")
public class CardResource {

    @Autowired
    private CardDAO dao;

    /**
     * This method is save or update an object
     */
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Card card){
        card.setUser("tomcat"); //todo Keep this to a user
        dao.save(card);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Card> getAll(@Context HttpServletRequest request) {
        List<Card> result = null;
        try {
            result = dao.loadAll();
        } catch (Exception e) {

        }
        return result;
    }

    @GET
    @Path("/{id:\\d+}")
    @Produces( MediaType.APPLICATION_JSON )
    public Card getById( @PathParam("id") Integer id){
        return dao.load(id);
    }

    @DELETE
    @Path("/remove/{id:\\d+}")
    public void remove(@PathParam("id") Integer id){
        dao.remove(id);
    }

}

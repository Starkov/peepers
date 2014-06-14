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

    @Autowired
    private CardMock mock;

    @GET
    @Path("/{id:\\d+}")
    @Produces( MediaType.APPLICATION_JSON )
    public Card getById( @PathParam("id") int id){
        return dao.load(id);
    }
    @GET
    @Path("/text")
    @Produces(MediaType.TEXT_PLAIN)
    public String testText(){

        return "test: " + mock.hello();
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

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Card card){
        card.setUser("tomcat");
        dao.save(card);
    }

}

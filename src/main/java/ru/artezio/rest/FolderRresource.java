package ru.artezio.rest;

import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;
import ru.artezio.dao.FolderDAO;
import ru.artezio.entity.node.Folder;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by astarkov on 09.07.2014.
 */
@ApplicationScoped
@Path("/folders")
public class FolderRresource {
    @EJB
    private FolderDAO folderDAO;

    @POST
    @Path("/add")
    @BadgerFish
    @Consumes("application/json")
    public void add(Folder folder) {
        Folder parentFolder = (Folder) folderDAO.load(folder.getParentHolderId());
        folder.setFolder(parentFolder);
        folderDAO.save(folder);
    }

    @GET
    @Path("/{id:\\d+}")
    @Produces("application/json")
    public Folder getById(@PathParam("id") Integer id) {
        return (Folder) folderDAO.load(id);
    }

    @DELETE
    @Path("/remove/{id:\\d+}")
    public void remove(@PathParam("id") Integer id) {
        folderDAO.remove(id);
    }

    @GET
    @Path("/all")
    @BadgerFish
    @Produces("application/json")
    public List getFolders() {
        List result = folderDAO.loadFoldersBy("tomcat");
        return result;
    }
}

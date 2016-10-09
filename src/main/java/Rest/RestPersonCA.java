/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entity.PersonCA;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import facade.FacadePersonCA;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;

@Path("Person")
public class RestPersonCA {

    @Context
    private UriInfo context;

    @Context
    private HttpHeaders headers;

    facade.FacadePersonCA FP;

    public RestPersonCA() {
        FP = new FacadePersonCA(Persistence.createEntityManagerFactory("CA_2"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Complete")
    public String getPersons() {
        System.out.println("getPersons");
        return new Gson().toJson(FP.getPersons());
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("{id}")
//    public String getPerson(@PathParam("id") int id) throws PersistenceException {
//        PersonCA p = FP.getPerson(id);
//
//        if (p == null) {
//            throw new PersistenceException();
//        }
//
//        return new Gson().toJson(p);
//    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String getPersonWithInfo(@PathParam("id") int id) throws PersistenceException {
        List<PersonCA> PCA = FP.getPersonByInfo(id);

        if (PCA == null) {
            throw new PersistenceException();
        }

        return new Gson().toJson(PCA);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Create")
    public PersonCA createPerson() throws SQLException {
    PersonCA p = new PersonCA();

        System.out.println("Creating Person");
   

    return (PersonCA) FP.addPerson(p);
}

//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("Create")
//    public String putPerson(String content) {
//        System.out.println("putPerson");
//
//        System.out.println(content);
//        JsonObject jo = new JsonParser().parse(content).getAsJsonObject();
//        System.out.println(jo.has("fName"));
//        System.out.println(jo.has("firstName"));
//        System.out.println(jo.get("firstName").getAsString());
//        System.out.println(jo.get("id").getAsInt());
//
//        return "{\"success\":true}";
//    }
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("All")
    public String deletePerson(@PathParam("id") int id) {

        FP. deletePerson(id);
    

    System.out.println (
    "deletePerson");

return "{\"success\":true}";
    }
}

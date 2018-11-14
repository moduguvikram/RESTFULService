package org.vik.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/UserService")
public class UserService {

    UserDao userDao = new UserDao();
/*
   @GET
   @Path("/users")
   @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   public List<User> getUsers(){
      return userDao.getAllUsers();
   }*/
   
/*
   @GET
   @Path("/users")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getUsers(){
      return Response.status(Response.Status.OK).entity(userDao.getAllUsers()).build();
   }
*/

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return userDao.getAllUsers();
    }

    @POST
    @Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<User> createUser(User user) {
        ArrayList<User> list = new ArrayList<User>();
        list.add(user);
        userDao.saveUserList(list);
        return userDao.getAllUsers();
    }

    @PUT
    @Path("/updateUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<User> updateUser(User user) {
        ArrayList<User> list = new ArrayList<User>();
        list.add(user);
        userDao.saveUserList(list);
        return userDao.getAllUsers();
    }


    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam("id") String id, @QueryParam("name") String name)
    {
        return "Hello " + id + " " + name;
    }


    @GET
    @Path("/{userName}")
    @Produces(MediaType.TEXT_PLAIN)
    public String printUserName(@PathParam("userName") String userId) {
        return userId;
    }


}


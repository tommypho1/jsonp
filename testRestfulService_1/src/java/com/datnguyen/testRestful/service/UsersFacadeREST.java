/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datnguyen.testRestful.service;

import com.datnguyen.testRestful.Utility.BuildWeb;
import com.datnguyen.testRestful.Utility.Utility;
import com.datnguyen.testRestful.entity.Users;
import com.google.gson.Gson;
import com.sun.jersey.api.json.JSONWithPadding;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author AsusVM
 */
@Stateless
@Path("com.datnguyen.testrestful.entity.users")
public class UsersFacadeREST extends AbstractFacade<Users> {
    @PersistenceContext(unitName = "testRestfulServicePU")
    private EntityManager em;

    public UsersFacadeREST() {
        super(Users.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Users entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Users entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Users find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Users> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Users> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @GET
    @Path("MapLink/{id}")
    @Produces("text/html")
    public String getMapLinkById(@PathParam("id") String id) {
        Double lat, lng;
        lat =  super.find(id).getLatitude();
        lng =  super.find(id).getLongtitude();
        return Utility.getHttpLocationFromLatLong(lat, lng);
    }
    
    @GET
    @Produces("application/x-javascript")
    @Path("MapLinkJson/{id}")
    public JSONWithPadding getMapLinkByIdJson (@QueryParam("callback") String callback,
                                 @PathParam("id") String id) {
        Gson gson = new Gson();
        Double lat, lng;
        lat =  super.find(id).getLatitude();
        lng =  super.find(id).getLongtitude();
        String msg = Utility.getHttpLocationFromLatLong(lat, lng);
        
        String json = gson.toJson(msg);
        return new JSONWithPadding(json,callback);
    }    
    
    
    @GET
    @Path("Map/{id}")
    @Produces("text/html")
    public String getMapById(@PathParam("id") String id) {
        Double lat, lng;
        lat =  super.find(id).getLatitude();
        lng =  super.find(id).getLongtitude();
        String imgHttp = Utility.getHttpLocationFromLatLong(lat, lng);
        return BuildWeb.buildWebMap(imgHttp);
    }
}

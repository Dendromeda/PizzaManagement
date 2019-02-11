/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.rest;

import business.entites.Pizza;
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
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jakob
 */
@Stateless
@Path("pizza")
public class PizzaRest extends integration.PizzaJPA{

    @PersistenceContext
    private EntityManager em;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void post(Pizza p){
        super.add(p);
    }
    
    @GET
    public List<Pizza> getAll(){
        return super.getAll();
    }
    
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void put(@PathParam("id") Integer id, Pizza p){
        p.setId(id);
        super.update(p);
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id){
        super.remove(id);
    }
    
    @GET
    @Path("{id}")
    public Pizza getbyId(@PathParam("id") Integer id){
        return super.get(id);
    }
    
    @GET
    @Path("{lo}/{hi}") 
    public List<Pizza> getByPriceRange(@PathParam("lo") Integer lo, 
                                        @PathParam("hi") Integer hi){
        return super.getByPriceRange(lo, hi);
        
    }
    
    
    
    
    
}

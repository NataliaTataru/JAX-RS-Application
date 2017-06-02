/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.chatREST.service;

import com.airhacks.chatREST.ChatLine;
import com.google.gson.Gson;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
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
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;

/**
 *
 * @author nataliat
 */
@Stateless
@Path("com.airhacks.chatrest.chatline")
public class ChatLineFacadeREST extends AbstractFacade<ChatLine> {

    @PersistenceContext(unitName = "com.mycompany_RestTest_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public ChatLineFacadeREST() {
        super(ChatLine.class);
    }

    @GET
    @Path("/userId2/{userId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Override
    public List<ChatLine> findByUserId(@PathParam("userId") int userId) {
        System.out.println("CONVERSATION***************");
        return super.findByUserId(userId);
    }
    
    @POST
    @Path("/insertConversationNativeGET2")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertConversationNativeGET(String conversation) {
        System.out.println("BOT RESPONSE ^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println(conversation);
//        ChatLine cl = new ChatLine();
//        cl.setBotResponse(conversation);
        Gson gs = new Gson();
        JSONObject jsonObj = new JSONObject(conversation);
        
        
        //ChatLine chatline = gs.fromJson(conversation, ChatLine.class);
        System.out.println("JSON-------------------------");
        System.out.println(jsonObj);
        
        
        super.insertConversationNativeGET(jsonObj);
    }
    
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(ChatLine entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, ChatLine entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ChatLine find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ChatLine> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ChatLine> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}

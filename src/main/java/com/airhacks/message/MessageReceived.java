/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.message;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author nataliat
 */
@Path("messages")
public class MessageReceived {
    @GET
    public String getMessage(){
        return "Hello";
    }
    
    @GET
    public String getMessage2(){
        return "Hello2";
    }
}

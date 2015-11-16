/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farley.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.farley.entity.GuestBook;
import com.farley.entity.GuestMessage;
import com.farley.entity.helper.OfyHelper;

import com.googlecode.objectify.ObjectifyService;

@Path("/json/sign")
public class GuestBookService {

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public GuestMessage getMessageInJSON() {

        GuestMessage guestMessage = new GuestMessage();
        //Track track = new Track();
        //track.setTitle("Enter Sandman");
        //track.setSinger("Metallica");

        return guestMessage;

    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createGuestMessageInJSON(GuestMessage message) {

        String result = "GuestMessage saved : " + message;

        // Use Objectify to save the greeting and now() is used to make the call synchronously as we
        // will immediately get a new page using redirect and we want the data to be present.
        ObjectifyService.ofy().save().entity(message).now();
        return Response.status(201).entity(result).build();
        
    }

}

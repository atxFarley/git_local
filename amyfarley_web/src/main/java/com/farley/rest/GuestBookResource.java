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

import com.farley.entity.GuestMessage;
import com.farley.service.GuestBookService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import com.fasterxml.jackson.databind.SerializationFeature;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.Query;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Path("/guestbook")
public class GuestBookResource {

    //@Context
    //UriInfo uriInfo;
    @GET
    @Path("sample")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessageInJSON() {
        System.out.println("in getMessage()");
        GuestBookService service = new GuestBookService();
        GuestMessage sampleGuestMsg = service.getSampleGuest();
        System.out.println("sampleGuestMsg: " + sampleGuestMsg);
        //bject json = null;
        //String returnJson = "";
        //ObjectMapper objectMapper = new ObjectMapper();
        //ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            //objectMapper.writeValue(new File("c:\\employee.json"), employee);
            //json = objectMapper.readValue(objectMapper.writeValueAsString(sampleGuestMsg), Object.class);
            //returnJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
            //System.out.println("json: " + returnJson);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
            //e.printStackTrace();
            //  json = "Exception caught";
        }

        //String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
        return Response.status(200).entity(sampleGuestMsg).build();

    }

    @GET
    @Path("list")
    //@Produces("text/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<GuestMessage> getGuestMessageListInJSON() {
        System.out.println("in getGuestMessageList()");
        List messages = new ArrayList();
        //Object json = null;
        //StringBuilder returnJson = new StringBuilder();
        //ObjectMapper objectMapper = new ObjectMapper();
        //ObjectMapper mapper = new ObjectMapper();
        // mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);

        // ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            //objectMapper.writeValue(new File("c:\\employee.json"), employee);

            Query<GuestMessage> q = ObjectifyService.ofy().load().type(GuestMessage.class);
            for (GuestMessage guestMessage : q) {
                messages.add(guestMessage);
                //json = (objectMapper.readValue(objectMapper.writeValueAsString(guestMessage), Object.class));
                // System.out.println("json object: " + json);
                //messages.add(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json));
                //returnJson.append(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json));
            }

            // System.out.println("json: " + returnJson.toString());
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
            //e.printStackTrace();
            //json = "Exception caught";
        }

        //String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
        //return Response.status(200).entity(messages).build();
        return messages;

    }

    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createGuestMessageInJSON(GuestMessage message) {
        System.out.println("createGuestMessageInJSON(message: " + message + ")");

        String result = "GuestMessage saved : " + message.toString();

        // Use Objectify to save the greeting and now() is used to make the call synchronously as we
        // will immediately get a new page using redirect and we want the data to be present.
        ObjectifyService.ofy().save().entity(message).now();
        System.out.println("result: " + result);
        return Response.status(201).entity(result).build();

    }

}

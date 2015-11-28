/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farley.servlet.guestbook;

import com.farley.entity.GuestMessage;
import com.farley.service.GuestBookService;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.google.gson.Gson;

import com.googlecode.objectify.ObjectifyService;
import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;

/**
 *
 * @author Amy
 */
@WebServlet("/sign")
public class GuestBookServlet extends HttpServlet {

    public GuestBookServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        GuestBookService service = new GuestBookService();
        GuestMessage sampleMessage = service.getSampleGuest();
        //Track track = new Track();
        //track.setTitle("Enter Sandman");
        //track.setSinger("Metallica");

        String json = new Gson().toJson(sampleMessage);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }

    // Process the http POST of the form
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        GuestMessage guestMessage = null;

        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader reader = req.getReader();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONParser parser = new JSONParser();
        JSONObject joMsg = null;
        try {
            joMsg = (JSONObject) parser.parse(sb.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String guestbookName = (String) joMsg.get("bookName");
        String message = (String) joMsg.get("message");
        String guest = (String) joMsg.get("guest");
        String email = (String) joMsg.get("guestEmail");
        float latitude = 0;
        float longitude = 0;

        guestMessage = new GuestMessage(guestbookName, message, email, guest, latitude, longitude);

        // Use Objectify to save the greeting and now() is used to make the call synchronously as we
        // will immediately get a new page using redirect and we want the data to be present.
        ObjectifyService.ofy().save().entity(guestMessage).now();

        

        //resp.sendRedirect("/guestbook.jsp?guestbookName=" + guestbookName);
    }

}

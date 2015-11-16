/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farley.servlet.guestbook;

import com.farley.entity.GuestMessage;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

/**
 *
 * @author Amy
 */
public class GuestBookServlet extends HttpServlet {

    // Process the http POST of the form
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        GuestMessage guestMessage = null;

   // UserService userService = UserServiceFactory.getUserService();
        //User user = userService.getCurrentUser();  // Find out who the user is.
        String guestbookName = req.getParameter("guestbookName");
        String message = req.getParameter("message");
        String email = "";
        float latitude = 0;
        float longitude = 0;

        guestMessage = new GuestMessage(guestbookName, message, email, latitude, longitude);

    // Use Objectify to save the greeting and now() is used to make the call synchronously as we
        // will immediately get a new page using redirect and we want the data to be present.
        ObjectifyService.ofy().save().entity(guestMessage).now();

        resp.sendRedirect("/guestbook.jsp?guestbookName=" + guestbookName);
    }

}

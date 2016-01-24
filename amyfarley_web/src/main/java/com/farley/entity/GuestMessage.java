/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farley.entity;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.appengine.api.datastore.GeoPt;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Amy
 */
@Entity
public class GuestMessage {

    @Parent
    private Key<GuestBook> guestBook;
    @Id
    private Long guestMessageId;

    private String guestEmail;
    private String guest;
    private String message;
    @Index
    private Date createdDate;
    private GeoPt guestLocation;

    /**
     * Simple constructor just sets the date
     *
     */
    public GuestMessage() {
        createdDate = new Date();
    }

    public GuestMessage(String guestBookName, String message) {
        this();
        if (guestBook != null) {
            guestBook = Key.create(GuestBook.class, guestBookName);  // Creating the Ancestor key
        } else {
            guestBook = Key.create(GuestBook.class, "default");
        }
        this.message = message;
    }

    /**
     * Takes all important fields
     *
     */
    public GuestMessage(String bookName, String message, String email, String guest) {
        this(bookName, message);
        this.guestEmail = email;
        this.guest = guest;
    }

    /**
     * Takes all important fields
     *
     */
    public GuestMessage(String bookName, String message, String email, String guest, float latitude, float longitude) {
        this(bookName, message);
        this.guestEmail = email;
        this.guest = guest;
        this.guestLocation = new GeoPt(latitude, longitude);
    }

    /**
     * @return the guestBook
     */
    @JsonIgnore
    public Key<GuestBook> getGuestBook() {
        return guestBook;
    }

    /**
     * @param guestBook the guestBook to set
     */
    @JsonIgnore
    public void setGuestBook(Key<GuestBook> guestBook) {
        this.guestBook = guestBook;
    }

    /**
     * @return the guestMessageId
     */
    public Long getGuestMessageId() {
        return guestMessageId;
    }

    /**
     * @return the guest
     */
    public String getGuest() {
        return guest;
    }

    /**
     * @param guest the guest to set
     */
    public void setGuest(String guest) {
        this.guest = guest;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @return the guestLocation
     */
    public GeoPt getGuestLocation() {
        return guestLocation;
    }

    /**
     * @param guestLocation the guestLocation to set
     */
    public void setGuestLocation(GeoPt guestLocation) {
        this.guestLocation = guestLocation;
    }

    /**
     * @return the guestEmail
     */
    public String getGuestEmail() {
        return guestEmail;
    }

    /**
     * @param guestEmail the guestEmail to set
     */
    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

}

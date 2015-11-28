/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farley.service;

import com.farley.entity.GuestMessage;

/**
 *
 * @author Amy
 */
public class GuestBookService {
    
    public GuestMessage getSampleGuest(){
        GuestMessage message = new GuestMessage("default", "Hello World", "test@test.com", "Testing Tester", 30.2746698f, -97.7425392f);
        return message;
    }
    
}

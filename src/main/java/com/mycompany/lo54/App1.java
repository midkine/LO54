/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lo54;

import com.mycompany.lo54.entity.Client;
import com.mycompany.lo54.entity.Course_Session;
import com.mycompany.lo54.entity.Location;
import com.mycompany.lo54.repository.HibernateClientDao;
import com.mycompany.lo54.repository.HibernateLocationDao;

/**
 *
 * @author Paul-Huang
 */
public class App1 {
    public static void main (String[] args){
        
        HibernateClientDao h = new HibernateClientDao();
        
        Client c = new Client();

        c.setCid(1);
        c.setFirstname("a");
        c.setLastname("bc");
        c.setAddress("anocanpan123");
        c.setPhone("123456");
        h.addUser(c);

        /*
        HibernateLocationDao h = new HibernateLocationDao();
        Location l = new Location();
        l.setId(1);
        l.setCity("Shanghai");
        h.addLocation(l);
    */
    }  
}

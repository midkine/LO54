/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lo54;

import com.mycompany.lo54.entity.Client;
import com.mycompany.lo54.entity.Course;
import com.mycompany.lo54.entity.Course_Session;
import com.mycompany.lo54.entity.Location;
import com.mycompany.lo54.repository.HibernateClientDao;
import com.mycompany.lo54.repository.HibernateLocationDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Paul-Huang
 */
public class App1 {
    public static void main (String[] args) throws ParseException{
        
        HibernateClientDao h = new HibernateClientDao();
        
        Client c = new Client();
        Location l = new Location ();
        Course co = new Course ();
        Course_Session cs = new Course_Session ();
        l.setLid(1);
        l.setCity("Shanghai");
        co.setCode("A001");
        co.setTitle("Math");
        cs.setCsid(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Date start_date = sdf.parse("2017-05-01"); 
        Date end_date = sdf.parse("2017-06-01");
        cs.setStart_date(start_date);
        cs.setEnd_date(end_date);
        cs.setCourse(co);
        cs.setLocation(l);
        c.setCid(1);
        c.setFirstname("a");
        c.setLastname("bc");
        c.setAddress("anocanan123");
        c.setPhone("123456");
        c.setCourse_session(cs);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lo54;

import com.mycompany.lo54.entity.Course_Session;
import com.mycompany.lo54.repository.HibernateCourse_SessionDao;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Paul-Huang
 */
public class App2 {
    public static void main (String[] args) throws ParseException{
        List<Map> list = new ArrayList();
        //List<Course_Session> list = new ArrayList<Course_Session>();
        HibernateCourse_SessionDao hcsd = new HibernateCourse_SessionDao();
        //list = hcsd.selectCourseByTitle("MATH");
        //list = hcsd.selectAllSession();
        list = hcsd.selectCourseByLocation("PARIS");
        for(Map map:list){
        //for(Course_Session cs:list)
            //System.out.println(cs.getLocation().getCity());
            System.out.println(map.get("course"));
        }
        //List<Object[]> list = hcsd.selectCourseByLocation("SHANGHAI");
    }
}


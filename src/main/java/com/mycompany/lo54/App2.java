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

/**
 *
 * @author Paul-Huang
 */
public class App2 {
    public static void main (String[] args) throws ParseException{
        Object[] obj = new Object[20];
        List<Object[]> list = new ArrayList();
        HibernateCourse_SessionDao hcsd = new HibernateCourse_SessionDao();
        list = hcsd.selectCourseByTitle("MATH");
        for(int i=0; i<list.size();i++){
            obj = list.get(i);           
            Course_Session cs = (Course_Session) obj[0];
            System.out.println(cs.getCsid());
        }
        //List<Object[]> list = hcsd.selectCourseByLocation("SHANGHAI");
    }
}

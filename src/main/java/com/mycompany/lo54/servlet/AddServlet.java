/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lo54.servlet;

import com.mycompany.lo54.entity.Client;
import com.mycompany.lo54.entity.Course_Session;
import com.mycompany.lo54.repository.HibernateClientDao;
import com.mycompany.lo54.repository.HibernateCourse_SessionDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Paul-Huang
 */
public class AddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Client c = new Client ();
        Course_Session cs = new Course_Session();
        HibernateClientDao hcd = new HibernateClientDao();
        HibernateCourse_SessionDao hcsd = new HibernateCourse_SessionDao();
        Integer cid = Integer.parseInt(request.getParameter("cid"));
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        HttpSession session=request.getSession();
        Integer csid=Integer.parseInt((String) session.getAttribute("csid"));
        try {
            /* TODO output your page here. You may use following sample code. */
            c.setCid(cid);
            c.setFirstname(firstname);
            c.setLastname(lastname);
            c.setAddress(address);
            c.setPhone(phone);
            cs = hcsd.selectCourseById(csid);
            c.setCourse_session(cs);
            hcd.addUser(c);
            RequestDispatcher dis=request.getRequestDispatcher("http://localhost:8080/LO54/addok");
            dis.forward(request,response);
        }
           catch(Exception e){
              RequestDispatcher dis=request.getRequestDispatcher("http://localhost:8080/LO54/addko"); 
           }
   finally {
            out.close();
        }
    }
}

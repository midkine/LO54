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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Paul-Huang
 */
@WebServlet(name= "AddServlet", urlPatterns= "/addservlet")
public class AddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Client c = new Client ();
        Course_Session cs = new Course_Session();
        HibernateClientDao hcd = new HibernateClientDao();
        HibernateCourse_SessionDao hcsd = new HibernateCourse_SessionDao();
        String cid = request.getParameter("cid");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Integer csid = Integer.parseInt(request.getParameter("csid"));
        
        //HttpSession session=request.getSession();
        //Integer csid=Integer.parseInt((String) session.getAttribute("csid"));
        try {
            /* TODO output your page here. You may use following sample code. */
            if(email !=null && email.length()>0){
                c.setEmail(email);
            }
            if(cid !=null && cid.length()>0){
                  Integer id = Integer.parseInt(cid);
                  Client c1= hcd.selectUser(id);
                  if(c1==null){
                    c.setCid(id);
                  }
                  else{
                      RequestDispatcher dis1=request.getRequestDispatcher("/error.jsp"); 
                      dis1.forward(request,response);
                  }
            }
            else{
                RequestDispatcher dis1=request.getRequestDispatcher("/addko"); 
                dis1.forward(request,response);
            }
            if(firstname !=null && firstname.length()>0){
                c.setFirstname(firstname);
            }
            else{
                RequestDispatcher dis1=request.getRequestDispatcher("/addko"); 
                dis1.forward(request,response);
            }
            if(lastname !=null && lastname.length()>0){
                c.setLastname(lastname);
            }
            else{
                RequestDispatcher dis1=request.getRequestDispatcher("/addko"); 
                dis1.forward(request,response);
            }
            if(address !=null && address.length()>0){
                c.setLastname(lastname);
            }
            else{
                RequestDispatcher dis1=request.getRequestDispatcher("/addko"); 
                dis1.forward(request,response);
            }
            if(phone !=null && phone.length()>0){
                c.setPhone(phone);
            }
            else{
                RequestDispatcher dis1=request.getRequestDispatcher("/addko"); 
                dis1.forward(request,response);
            }
            cs = hcsd.selectCourseById(csid);
            c.setCourse_session(cs);
            hcd.addUser(c);
            RequestDispatcher dis=request.getRequestDispatcher("/addok");
            dis.forward(request,response);
        }
           catch(Exception e){
           }
   finally {
            out.close();
        }
    }
}

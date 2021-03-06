/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lo54.servlet;

import com.mycompany.lo54.entity.Course_Session;
import com.mycompany.lo54.repository.HibernateCourse_SessionDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paul-Huang
 */
@WebServlet(name = "SearchCSByDateServlet", urlPatterns = "/searchcsbydate")
public class SearchCSByDateServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HibernateCourse_SessionDao hcsd = new HibernateCourse_SessionDao();
        String date = request.getParameter("date");
        List<Course_Session> list = new ArrayList<Course_Session>();
        try {
        list = hcsd.selectCourseByDate(date);
        } catch (ParseException ex) {
        Logger.getLogger(SearchCSByDateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (list.size()==0){
                RequestDispatcher dis1=request.getRequestDispatcher("/noresult.jsp"); 
                dis1.forward(request,response);
            }
        else{
        try {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Search Result</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Search Result</h1>\n");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Start Date</th>");
            out.println("<th>End Date</th>");
            out.println("<th>Course</th>");
            out.println("<th>Location</th>");
            out.println("</tr>");  
            for(Course_Session cs:list){ 
            out.println("<tr>");
            out.println("<td><a href='http://localhost:8080/LO54/AddInfo.jsp?id=" +cs.getCsid()+"'>"+cs.getCsid()+"</a></td>");
            out.println("<td>" +cs.getStart_date()+"</td>");
            out.println("<td>" +cs.getEnd_date()+"</td>");
            out.println("<td>" +cs.getCourse().getTitle()+"</td>");
            out.println("<td>" +cs.getLocation().getCity()+"</td>");
            out.println("</tr>");
            }
            out.println("</table>");
            out.println("<a href='http://localhost:8080/LO54/searchcsall'>Back</a>");
            out.println("</body>");
            out.println("</html>");
         }
          finally {
            out.close();
        }
   }
}
}

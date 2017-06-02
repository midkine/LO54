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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paul-Huang
 */
@WebServlet(name = "SearchCSAllServlet", urlPatterns = "/searchcsall")
public class SearchCSAllServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HibernateCourse_SessionDao hcsd = new HibernateCourse_SessionDao();
        List<Course_Session> list = new ArrayList<Course_Session>();
        list = hcsd.selectAllSession();
        
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
            //Integer id = cs.getCsid();
            out.println("<tr>");
            out.println("<td><a href='http://localhost:8080/LO54/AddInfo.jsp?id=" +cs.getCsid()+"'>"+cs.getCsid()+"</a></td>");
            out.println("<td>" +cs.getStart_date()+"</td>");
            out.println("<td>" +cs.getEnd_date()+"</td>");
            out.println("<td>" +cs.getCourse().getTitle()+"</td>");
            out.println("<td>" +cs.getLocation().getCity()+"</td>");
            out.println("</tr>");
            }
            out.println("</table>");
            out.println("<p>Search by title</p>");
            out.println("<form action='searchcsbytitle' methode='GET'>");
            out.println("Title: <input type= 'text' name='title'/>");
            out.println("<input type ='submit' value='search'>");
            out.println("</form>");
            out.println("<p>Search by date ( Format: yyyy-mm-dd )</p>");
            out.println("<form action='searchcsbydate' methode='GET'>");
            out.println("Date: <input type= 'text' name='date'/>");
            out.println("<input type ='submit' value='search'>");
            out.println("</form>");
            out.println("<p>Search by location</p>");
            out.println("<form action='searchcsbylocation' methode='GET'>");
            out.println("Location: <input type= 'text' name='location'/>");
            out.println("<input type ='submit' value='search'>");
            out.println("</form>");
            out.println("<a href='http://localhost:8080/LO54/Home.jsp'>Back to HomePage</a>");
            out.println("</body>");
            out.println("</html>");
         }
          finally {
            out.close();
        }
   }
}

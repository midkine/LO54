/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lo54.servlet;

import com.mycompany.lo54.entity.Course;
import com.mycompany.lo54.entity.Course_Session;
import com.mycompany.lo54.entity.Location;
import com.mycompany.lo54.repository.HibernateCourse_SessionDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paul-Huang
 */
public class SearchCSByLocationServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HibernateCourse_SessionDao hcsd = new HibernateCourse_SessionDao();
        Course_Session cs = new Course_Session();
        String location = request.getParameter("location");
        List<Map> list = new ArrayList<Map>();
        list = hcsd.selectCourseByLocation(location);
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
            for(Map map:list){
            //Integer id = (Integer) map.get("id");
            out.println("<tr>");
            out.println("<td><a href='http://localhost:8080/LO54/AddInfo.jsp?id=" +(Integer) map.get("id")+"'>"+(Integer) map.get("id")+"</a></td>");
            out.println("<td>" +(Date) map.get("sdate")+"</td>");
            out.println("<td>" +(Date) map.get("edate")+"</td>");
            out.println("<td>" +((Course)map.get("course")).getTitle()+"</td>");
            out.println("<td>" +((Location)map.get("location")).getCity()+"</td>");
            out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
         }
          finally {
            out.close();
        }
   }
}

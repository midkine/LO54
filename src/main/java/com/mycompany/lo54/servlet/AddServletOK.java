/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lo54.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paul-Huang
 */
@WebServlet(name = "AddServletOK", urlPatterns = "/addok")
public class AddServletOK extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Add Success</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Add Success</h1>\n");
            out.println("<a href='http://localhost:8080/LO54/searchcsall'>Back to the list page</a><br/>");
            out.println("</body>");
            out.println("</html>");
         }
          finally {
            out.close();
        }
   }
}

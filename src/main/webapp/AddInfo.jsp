<%-- 
    Document   : AddInfo
    Created on : 2017-5-29, 16:44:00
    Author     : Paul-Huang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add info</title>
    </head>
    <body>
        <h1>Please add your personnal infomations!</h1>
        <% out.print("You have select Course_Session "+request.getParameter("id")); %>
        <form action="http://localhost:8080/addservlet" methode="GET">
            <input type="hidden" name="csid" value="<% out.print(request.getParameter("id")); %>"/>
            ID: <input type="text" name="cid"/></br>
            Lastname: <input type="text" name="lastname"/></br>
            Firstname: <input type="text" name="firstname"/></br>
            Address: <input type="text" name="address"/></br>
            Phone: <input type="text" name="phone"/></br>
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>

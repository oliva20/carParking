<%-- 
    Document   : Meter
    Created on : 02-Jan-2019, 17:19:41
    Author     : Andre
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="org.solent.carPark.web.WebObjectFactory"%>
<%@page import="org.solent.carPark.model.ServiceFactory"%>
<%@page import="org.solent.carPark.model.ServiceFacade"%>
<%@page import="org.solent.carPark.model.Meter"%>
<%@page import = "java.io.*,java.util.*, javax.servlet.*" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Meter</title>
    </head>
    
    <%
    ServiceFacade serviceFacade = (ServiceFacade) session.getAttribute("serviceFacade");
    
    %> 
    <body>
        
        <h1 align="left">Meter</h1>
        
        <%
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd");
        SimpleDateFormat h = new SimpleDateFormat("hh:mm"); 
        
        //display current date
        out.print( "<h2 align = \"left\">" +ft.format(date) +"</h2>");
        //displat current hour
        out.print( "<h2 align = \"left\">" +h.format(date) +"</h2>");
        %>
        
        <p>Please select the number of hours: </p>
        
        <input type="text" name="price" value ="<%%>">  
        
      
    </body>
</html>

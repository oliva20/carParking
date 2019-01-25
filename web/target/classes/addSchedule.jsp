<%-- 
    Document   : addSchedule
    Created on : 15-Jan-2019, 23:20:02
    Author     : Andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="org.solent.carPark.web.WebObjectFactory"%>
<%@page import="org.solent.carPark.model.ServiceFactory"%>
<%@page import="org.solent.carPark.model.ServiceFacade"%>
<%@page import="org.solent.carPark.model.Meter"%>
<%@page import="org.solent.carPark.model.ScheduleItem"%>
<%@page import="org.solent.carPark.model.*"%>

<%
    ServiceFacade serviceFacade = (ServiceFacade) session.getAttribute("serviceFacade");

    // If the user session has no bankApi, create a new one
    if (serviceFacade == null) {
        ServiceFactory serviceFactory = WebObjectFactory.getServiceFactory();
        serviceFacade = serviceFactory.getServiceFacade();
        session.setAttribute("ServiceFacade", serviceFacade);
    }
    
    //get request values
    String action = (String) request.getParameter("action");
    String idReq =  (String) request.getParameter("id");
    String timeReq =  (String) request.getParameter("time");
    String priceReq =  (String) request.getParameter("price");
    
    Integer scheduleId = 1;
    
    Integer meterId = 16;
    
    Meter m1 = serviceFacade.retrieveMeter(meterId);
            
    ScheduleItem schedule = new ScheduleItem(); 
    
    schedule.setId(scheduleId);
    schedule.setPrice(priceReq);
    schedule.setTime(timeReq);
    
    m1.addSchedule(schedule);
    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Add Schedule</title>
    </head>
    <body>
        <table>
            <tr>
              <th>Meter ID</th>
              <th>Time</th>
              <th>Price</th>
            </tr>
            <tr>
                <td><input type="text" name="id" value =""></td>
                <td><input type="text" name="price" value =""></td>
                <td><input type="text" name="time" value =""></td>
            </tr>
        </table>
        
        <form action="ListMeters.jsp">
            <input type="submit" value="Add Schedule">
        </form>
    </body>
</html>

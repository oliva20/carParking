<%-- 
    Document   : AddOrModifyMeter
    Created on : Nov 30, 2018, 11:17:38 PM
    Author     : cgallen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="org.solent.carPark.web.WebObjectFactory"%>
<%@page import="org.solent.carPark.model.ServiceFactory"%>
<%@page import="org.solent.carPark.model.ServiceFacade"%>
<%@page import="org.solent.carPark.model.Meter"%>


<%

    ServiceFacade serviceFacade = (ServiceFacade) session.getAttribute("serviceFacade");

    // If the user session has no bankApi, create a new one
    if (serviceFacade == null) {
        ServiceFactory serviceFactory = WebObjectFactory.getServiceFactory();
        serviceFacade = serviceFactory.getServiceFacade();
        session.setAttribute("ServiceFacade", serviceFacade);
    }

    // get request values
    String action = (String) request.getParameter("action");
    String meterIdReq = (String) request.getParameter("meterId");
    String meterLocationReq = (String) request.getParameter("location");
    String meterPriceReq = (String) request.getParameter("price");

    String errorMessage = "";

    Meter meter = null;
    Integer meterId = null;

    if ("modifyMeter".equals(action)) {
        try {
            meterId = Integer.parseInt(meterIdReq);
            meter = serviceFacade.retrieveMeter(meterId);
        } catch (Exception e) {
            errorMessage = "problem finding meter " + e.getMessage();
        }
    } else if ("createMeter".equals(action)) {
        try {
            meter = new Meter();
        } catch (Exception e) {
            errorMessage = "problem finding meter " + e.getMessage();
        }
    } else {
        errorMessage = "cannot recognise action: " + action;
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Edit Meter</title>
    </head>
    <body>
        <% if ("createMeter".equals(action)) {
        %>
        <h1>Add New Meter</h1>
        <% } else {%>
        <h1>Modify Meter <%=meterId%></h1>
        <% }%>
        <form action="ListMeters.jsp">
            <table>
                <tr>
                    <th>Field</th>
                    <th>Current Value</th>
                    <th>New Value</th>
                </tr>
                <tr>
                    <td>Meter Id</td>
                    <td><%=meter.getId()%></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Location</td>
                    <td><%=meter.getLocation()%></td>
                    <td><input type="text" name="location" value ="<%=meter.getLocation()%>"></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><%=meter.getPrice()%></td>
                    <td><input type="text" name="price" value ="<%=meter.getPrice()%>"></td>
                </tr>
            </table> 
            <BR>
            <% if ("createMeter".equals(action)) {
            %>
            <input type="hidden" name="action" value="createMeter">
            <input type="hidden" name="meterId" value="<%=meterId%>">
            <input type="submit" value="Create New Meter">
            <% } else if ("modifyMeter".equals(action)) {
            %>
            <input type="hidden" name="action" value="modifyMeter">
            <input type="hidden" name="meterId" value="<%=meterId%>">
            <input type="submit" value="Modify Meter">
            <% }%>
     
            
        </form>
        <form action="ListMeters.jsp">
            <input type="submit" value="Cancel and Return">
        </form>
    </body>
</html>

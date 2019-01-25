<%-- 
    Document   : ListEntities
    Created on : Nov 30, 2018, 11:17:02 PM
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
    if ("deleteMeter".equals(action)) {
        try {
            Integer meterId = Integer.parseInt(meterIdReq);
            serviceFacade.deleteMeter(meterId);
        } catch (Exception e) {
            errorMessage = "problem deleting Meter " + e.getMessage();
        }
    } else if ("modifyMeter".equals(action)) {
        try {
            Integer meterId = Integer.parseInt(meterIdReq);
            Meter newMeter = new Meter();
            newMeter.setId(meterId);
            newMeter.setLocation(meterLocationReq);
            newMeter.setPrice(meterPriceReq);
            Meter meter = serviceFacade.updateMeter(newMeter);
            if (meter == null) {
                errorMessage = "problem modifying Meter. could not find meterId " + meterId;
            }
        } catch (Exception e) {
            errorMessage = "problem modifying Meter " + e.getMessage();
        }
    } else if ("createMeter".equals(action)) {
        try {
            Meter meter = new Meter();
            meter.setLocation(meterLocationReq);
            meter.setPrice(meterPriceReq);
            Meter meter1 = serviceFacade.createMeter(meter);
            if (meter1 == null) {
                errorMessage = "problem creating Meter. Service returned null ";
            }
        } catch (Exception e) {
            errorMessage = "problem creating Meter " + e.getMessage();
        }
    } 

    List<Meter> meterList = serviceFacade.retrieveAllMeters();

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Meter List</title>
    </head>
    <body>
        <!-- print error message if there is one -->
        <div style="color:red;"><%=errorMessage%></div>
        <h1>Meter List</h1>
        <table>
            <tr>
                <th>id</th>
                <th>Location</th>
                <th>Price</th>
                
            </tr>
            <%  for (Meter meter : meterList) {
            %>
            <tr>
                <td><%=meter.getId()%></td>
                <td><%=meter.getLocation()%></td>
                <td><%=meter.getPrice()%></td>
                
                <td>
                    <form action="AddOrModifyMeter.jsp">
                        <input type="hidden" name="action" value="modifyMeter">
                        <input type="hidden" name="meterId" value="<%=meter.getId()%>">
                        <input type="submit" value="Modify Meter">
                    </form>
                    <form action="ListMeters.jsp">
                        <input type="hidden" name="action" value="deleteMeter">
                        <input type="hidden" name="meterId" value="<%=meter.getId()%>">
                        <input type="submit" value="Delete Meter">
                    </form>
                    <form action="Meter.jsp">
                        <input type="hidden" name="action" value="meterUI">
                        <input type="hidden" name="meterId" value="<%=meter.getId()%>">
                        <input type="submit" value="Meter UI">
                    </form>
                </td>
            </tr>
            <% }%>

        </table> 
        <BR>
        <form action="AddOrModifyMeter.jsp">
            <input type="hidden" name="action" value="createMeter">
            <input type="submit" value="Create Meter">
        </form>
    </body>
</html>
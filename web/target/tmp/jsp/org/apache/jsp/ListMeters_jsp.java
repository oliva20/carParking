package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import org.solent.carPark.web.WebObjectFactory;
import org.solent.carPark.model.ServiceFactory;
import org.solent.carPark.model.ServiceFacade;
import org.solent.carPark.model.Meter;

public final class ListMeters_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");


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


      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\r\n");
      out.write("        <title>Meter List</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <!-- print error message if there is one -->\r\n");
      out.write("        <div style=\"color:red;\">");
      out.print(errorMessage);
      out.write("</div>\r\n");
      out.write("        <h1>Meter List</h1>\r\n");
      out.write("        <table>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>id</th>\r\n");
      out.write("                <th>Location</th>\r\n");
      out.write("                <th>Price</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");
  for (Meter meter : meterList) {
            
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>");
      out.print(meter.getId());
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(meter.getLocation());
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print(meter.getPrice());
      out.write("</td>\r\n");
      out.write("                \r\n");
      out.write("                <td>\r\n");
      out.write("                    <form action=\"AddOrModifyMeter.jsp\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"action\" value=\"modifyMeter\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"meterId\" value=\"");
      out.print(meter.getId());
      out.write("\">\r\n");
      out.write("                        <input type=\"submit\" value=\"Modify Meter\">\r\n");
      out.write("                    </form>\r\n");
      out.write("                    <form action=\"ListMeters.jsp\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"action\" value=\"deleteMeter\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"meterId\" value=\"");
      out.print(meter.getId());
      out.write("\">\r\n");
      out.write("                        <input type=\"submit\" value=\"Delete Meter\">\r\n");
      out.write("                    </form>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");
 }
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </table> \r\n");
      out.write("        <BR>\r\n");
      out.write("        <form action=\"AddOrModifyMeter.jsp\">\r\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"createMeter\">\r\n");
      out.write("            <input type=\"submit\" value=\"Create Meter\">\r\n");
      out.write("        </form>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

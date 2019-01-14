package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import org.solent.carPark.web.WebObjectFactory;
import org.solent.carPark.model.ServiceFactory;
import org.solent.carPark.model.ServiceFacade;
import org.solent.carPark.model.Meter;

public final class AddOrModifyMeter_jsp extends org.apache.jasper.runtime.HttpJspBase
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


      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\r\n");
      out.write("        <title>Edit Meter</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
 if ("createMeter".equals(action)) {
        
      out.write("\r\n");
      out.write("        <h1>Add New Meter</h1>\r\n");
      out.write("        ");
 } else {
      out.write("\r\n");
      out.write("        <h1>Modify Meter ");
      out.print(meterId);
      out.write("</h1>\r\n");
      out.write("        ");
 }
      out.write("\r\n");
      out.write("        <form action=\"ListMeters.jsp\">\r\n");
      out.write("            <table>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>Field</th>\r\n");
      out.write("                    <th>Current Value</th>\r\n");
      out.write("                    <th>New Value</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Meter Id</td>\r\n");
      out.write("                    <td>");
      out.print(meter.getId());
      out.write("</td>\r\n");
      out.write("                    <td></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Location</td>\r\n");
      out.write("                    <td>");
      out.print(meter.getLocation());
      out.write("</td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"location\" value =\"");
      out.print(meter.getLocation());
      out.write("\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Price</td>\r\n");
      out.write("                    <td>");
      out.print(meter.getPrice());
      out.write("</td>\r\n");
      out.write("                    <td><input type=\"text\" name=\"price\" value =\"");
      out.print(meter.getPrice());
      out.write("\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table> \r\n");
      out.write("            <BR>\r\n");
      out.write("            ");
 if ("createMeter".equals(action)) {
            
      out.write("\r\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"createMeter\">\r\n");
      out.write("            <input type=\"hidden\" name=\"meterId\" value=\"");
      out.print(meterId);
      out.write("\">\r\n");
      out.write("            <input type=\"submit\" value=\"Create New Meter\">\r\n");
      out.write("            ");
 } else if ("modifyMeter".equals(action)) {
            
      out.write("\r\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"modifyMeter\">\r\n");
      out.write("            <input type=\"hidden\" name=\"meterId\" value=\"");
      out.print(meterId);
      out.write("\">\r\n");
      out.write("            <input type=\"submit\" value=\"Modify Meter\">\r\n");
      out.write("            ");
 }
      out.write("\r\n");
      out.write("        </form>\r\n");
      out.write("        <form action=\"ListMeters.jsp\">\r\n");
      out.write("            <input type=\"submit\" value=\"Cancel and Return\">\r\n");
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

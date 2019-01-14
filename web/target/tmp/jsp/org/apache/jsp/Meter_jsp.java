package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.util.List;
import org.solent.carPark.web.WebObjectFactory;
import org.solent.carPark.model.ServiceFactory;
import org.solent.carPark.model.ServiceFacade;
import org.solent.carPark.model.Meter;
import java.io.*;
import java.util.*;
import javax.servlet.*;

public final class Meter_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Meter</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    ");

    ServiceFacade serviceFacade = (ServiceFacade) session.getAttribute("serviceFacade");
    
    
      out.write(" \n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <h1 align=\"left\">Meter</h1>\n");
      out.write("        \n");
      out.write("        ");

        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd");
        SimpleDateFormat h = new SimpleDateFormat("hh:mm"); 
        
        //display current date
        out.print( "<h2 align = \"left\">" +ft.format(date) +"</h2>");
        //displat current hour
        out.print( "<h2 align = \"left\">" +h.format(date) +"</h2>");
        
      out.write("\n");
      out.write("        \n");
      out.write("        <p>Please select the number of hours: </p>\n");
      out.write("        \n");
      out.write("        <input type=\"text\" name=\"price\" value =\"");

      out.write("\">  \n");
      out.write("        \n");
      out.write("      \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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

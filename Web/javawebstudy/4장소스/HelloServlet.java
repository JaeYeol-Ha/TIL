package core;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	   
      response.setContentType("text/html; charset=utf-8");	  
	  response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();

      out.println("<h3>안녕하세요?</h3>");
      out.close();
   }
}
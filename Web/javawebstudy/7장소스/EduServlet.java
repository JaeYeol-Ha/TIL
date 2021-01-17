package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/eduServlet")
public class EduServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		
		int scoreAvg = Integer.parseInt(request.getParameter("scoreavg"));	
		String uri = "";		
		if(scoreAvg>=90)
			uri = "/view/gradeA.jsp";
		else if(scoreAvg>=80)
			uri = "/view/gradeB.jsp";
		else if(scoreAvg>=70)
			uri = "/view/gradeC.jsp";
		else
			uri = "/view/gradeD.jsp";		
		request.getRequestDispatcher(uri).forward(request, response);		
	}
}
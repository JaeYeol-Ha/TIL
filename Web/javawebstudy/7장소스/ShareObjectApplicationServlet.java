package controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.CountVO;

@WebServlet("/applicationshare")
public class ShareObjectApplicationServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = getServletContext();
		if (context.getAttribute("applicationobj") == null)
			context.setAttribute("applicationobj", new CountVO());
		CountVO vo = (CountVO) context.getAttribute("applicationobj");
		vo.setNumber(10);
		request.getRequestDispatcher("/view/applicationView.jsp").forward(request, response);
	}
}

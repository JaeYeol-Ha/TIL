package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.vo.CountVO;

@WebServlet("/sessionshare")
public class ShareObjectSessionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("sessionobj") == null)
			session.setAttribute("sessionobj", new CountVO());
		CountVO vo = (CountVO) session.getAttribute("sessionobj");
		vo.setNumber(10);
		request.getRequestDispatcher("/view/sessionView.jsp").forward(request, response);
	}
}

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.CountVO;

@WebServlet("/requestshare")
public class ShareObjectRequestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CountVO vo = new CountVO();
		vo.setNumber(10);
		request.setAttribute("requestobj", vo);
		request.getRequestDispatcher("/view/requestView.jsp").forward(request, response);

	}
}

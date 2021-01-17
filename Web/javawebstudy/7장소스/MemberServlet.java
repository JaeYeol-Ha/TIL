package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.EncDecService;
import model.vo.MemberVO;

@WebServlet("/memberServlet")
public class MemberServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/view/memberView.jsp";		
		request.setCharacterEncoding("utf-8");		
		MemberVO mvo = new MemberVO();		
		mvo.setName(request.getParameter("name"));
		mvo.setPhoneNum(request.getParameter("phonenumber"));
		mvo.setId(request.getParameter("id"));
		String pwd = request.getParameter("passwd");
		String encPwd = EncDecService.encrypt(pwd); 
		mvo.setPasswd(encPwd);		
		request.setAttribute("membervo", mvo);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
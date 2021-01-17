package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.VisitorDAO;
import model.vo.VisitorVO;
@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
	Random rand = new Random();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			                 throws ServletException, IOException {
		String selectedView = "/view/visitorView1.jsp";
		if(rand.nextBoolean()) {
			selectedView = "/view/visitorView2.jsp";
		}
		VisitorDAO dao = new VisitorDAO();
		ArrayList<VisitorVO> list = dao.listAll();
		if (list != null && list.size() > 0) {
			request.setAttribute("list", list);
		} else {
			request.setAttribute("msg", "방명록에 저장된 글이 없어요...");
		}
		request.getRequestDispatcher(selectedView).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			          throws ServletException, IOException {
		String insertedView = "/view/visitorView1.jsp";
		if(rand.nextBoolean()) {
			insertedView = "/view/visitorView2.jsp";
		}
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		VisitorVO vo = new VisitorVO();
		vo.setName(name);
		vo.setContent(content);
		VisitorDAO dao = new VisitorDAO();
		boolean result = dao.insert(vo);
		if (result) {
			request.setAttribute("msg", name + "님의 글이 성공적으로 저장되었어요!");
		} else {
			request.setAttribute("msg", name + "님의 글 저장에 실패하였어요!");
		}
		request.getRequestDispatcher(insertedView).forward(request, response);
	}
}

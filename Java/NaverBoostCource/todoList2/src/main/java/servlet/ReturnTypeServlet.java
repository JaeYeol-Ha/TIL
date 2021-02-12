package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDao;

@WebServlet("/ReturnTypeServlet")
public class ReturnTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TodoDao dao = null;

	public ReturnTypeServlet() {
		super();
		dao = new TodoDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String type = req.getParameter("type");
		
		if(type.equals("DOING"))
			type = "TODO";
		else if(type.equals("DONE"))
			type = "DOING";
		dao.returnTodo(id, type);
		PrintWriter out = resp.getWriter();
		out.print("success");
		out.close();
	}
}

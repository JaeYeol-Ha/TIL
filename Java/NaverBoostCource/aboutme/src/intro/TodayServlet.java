package intro;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/today")
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<a href=\"http://localhost:8080/aboutme/index.html\">메인화면</a><br><br>");
		LocalDateTime currentDateTime = LocalDateTime.now();
		String time = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
		out.println("<h1 style=\"text-align:center\";> 현재시간 : " + time + "</h1>");
		out.close();
	}
}


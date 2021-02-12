//package intro;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/index")
//public class IndexPage extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    public IndexPage() {
//        super();
//    }
//    
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("<h1>1~10까지 출력!!<h1>");
//		for(int i =1; i<=10; i++) {
//			out.println(i + "<br>");
//		}
//		out.close();
//	}
//}

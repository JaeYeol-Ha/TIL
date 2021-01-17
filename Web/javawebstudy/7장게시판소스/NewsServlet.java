package controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.NewsDAO; 
import model.vo.NewsVO;
@WebServlet("/news.do")
public class NewsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String action = request.getParameter("action");
		String param = request.getParameter("pgNum");
		int pgNum = param == null ? 1 : Integer.parseInt(param);
		NewsDAO dao = new NewsDAO();
		List<NewsVO> list = null;
		int count = 0;
		String linkStr = "";
		if(action == null){
			list = dao.listAll(pgNum);
			request.setAttribute("msg", "뉴스 게시판");
			if(list != null && list.size() != 0){				
				request.setAttribute("list", list);
			}
			count = dao.getCount();
		}else if(action.equals("sort")){			
			String key = request.getParameter("key");
			list = dao.listSort(key, pgNum);
			request.setAttribute("msg", "뉴스 리스트("+key+"정렬)");
			if(list != null && list.size() != 0){				
				request.setAttribute("list", list);
			} 
			count = dao.getCount();
			linkStr = "&action=sort&key="+key;
		} else if(action.equals("listone")){
			int id = Integer.parseInt(request.getParameter("id"));
			NewsVO vo = dao.listOne(id);			
			if(vo != null){				
				request.setAttribute("msg", "뉴스 내용");
				request.setAttribute("vo", vo);								
			} 
		} else if(action.equals("listwriter")){
			String writer = request.getParameter("writer");
			list = dao.listWriter(writer, pgNum);
			request.setAttribute("msg", "뉴스 게시판");
			if(list != null && list.size() != 0){				
				request.setAttribute("list", list);
				request.setAttribute("etc", "fulllistbutton");
				count = dao.getCount(writer);	
				linkStr="&action=listwriter&writer="+writer;
			} 
		} else if(action.equals("search")) {
			String key = request.getParameter("key");
			String searchType = request.getParameter("searchType");			
			list = dao.search(key, searchType, pgNum );				
			if(list!=null && list.size() != 0){
				request.setAttribute("msg", key + "을 포함하는 News 글 리스트");
				request.setAttribute("list", list);
				request.setAttribute("etc", "fulllistbutton");
				count = dao.getCount(key, searchType);
				linkStr="&searchType="+searchType+"&key="+key+"&action=search";
			}else{
				request.setAttribute("snull", key + "을 포함하는 검색글이 없습니다.");
			}
			
		} else if(action.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));	
			dao.delete(id);
			response.sendRedirect("/mvc/news.do?pgNum="+pgNum);
			return;
		}			
		request.setAttribute("totalCount", count);
		request.setAttribute("pagelist", new NewsDAO().getPageLinkList(pgNum, linkStr, count));
		request.setAttribute("pgNum", pgNum);
		request.getRequestDispatcher("/view/newsView.jsp").
		         forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		String paramId = request.getParameter("id");
		String param = request.getParameter("pgNum");
		int pgNum = param == null ? 1 : Integer.parseInt(param);
		
		NewsDAO dao = new NewsDAO();
		NewsVO vo = new NewsVO();
		if (paramId != null)
			vo.setId(Integer.parseInt(paramId));
		vo.setWriter(request.getParameter("writer"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		if(action.equals("insert")) {
			vo.setViewCount(0);
			dao.insert(vo);
		} else if(action.equals("update")) {
			dao.update(vo);
		} 
		response.sendRedirect("/mvc/news.do?pgNum="+pgNum);
	}
}






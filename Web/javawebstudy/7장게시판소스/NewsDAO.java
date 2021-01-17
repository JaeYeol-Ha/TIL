
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.vo.NewsVO;

public class NewsDAO {
	private Connection getConnect() {
		Connection conn = null;
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			System.out.println("jdbc/myoracle 이름으로 객체를 찾을 수 없습니다.");
		}
		return conn;
	}

	public boolean insert(NewsVO vo) {
		boolean flag = false;
		PreparedStatement stmt = null;
		Connection conn = getConnect();
		try {
			stmt = conn.prepareStatement("insert into news values " + "(news_seq.nextval, ?, ?, ?, ?,0)");
			stmt.setString(1, vo.getWriter());
			stmt.setString(2, vo.getTitle());
			stmt.setString(3, vo.getContent());
			stmt.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
			int result = stmt.executeUpdate();
			if (result == 1)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);
		}
		return flag;
	}

	public boolean update(NewsVO vo) {
		boolean flag = false;
		PreparedStatement stmt = null;
		Connection conn = getConnect();
		try {
			stmt = conn.prepareStatement("update news set writer =?, title=?, content=? " + "where id = ?");
			stmt.setString(1, vo.getWriter());
			stmt.setString(2, vo.getTitle());
			stmt.setString(3, vo.getContent());
			stmt.setInt(4, vo.getId());
			int result = stmt.executeUpdate();
			if (result == 1)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);
		}
		return flag;
	}

	public int delete(int id) {
		int num = 0;
		Statement stmt = null;
		Connection conn = getConnect();
		try {
			stmt = conn.createStatement();
			num = stmt.executeUpdate("delete from news where id = " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);
		}
		return num;
	}
	
	public int  getCount() {
		Statement stmt = null;
		ResultSet rs = null;
		int totalCount = 0;
		Connection conn = getConnect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from news");
			rs.next();
			totalCount = rs.getInt(1);			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}
		return totalCount;
	}
	public int  getCount(String writer) {
		Statement stmt = null;
		ResultSet rs = null;
		int totalCount = 0;
		Connection conn = getConnect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from news where writer = '"+writer+"'");
			rs.next();
			totalCount = rs.getInt(1);			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}
		return totalCount;
	}
	public int  getCount(String key, String searchType) {
		Statement stmt = null;
		ResultSet rs = null;
		int totalCount = 0;
		Connection conn = getConnect();
		String searchExpr;
		try {
			stmt = conn.createStatement();
			if (searchType.equals("content")) {
				searchExpr = " content like '%" + key + "%'";
			} else if (searchType.equals("title")) {
				searchExpr = " title like '%" + key + "%'";
			} else {
				searchExpr = " title like '%" + key + "%'" + " OR content like '%" + key + "%'";
			}
			rs = stmt.executeQuery("select count(*) from news where " + searchExpr);
			rs.next();
			totalCount = rs.getInt(1);			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}
		return totalCount;
	}
	public String getPageLinkList(int curPage, String linkStr, int size) {
		PagingControl page = new PagingControl(5,5,size, curPage);
		StringBuilder buffer = new StringBuilder();
		if(page.isPreData()) {
			buffer.append("<a href='/mvc/news.do?pgNum=");
			buffer.append((page.getPageStart()-1)+linkStr+"'>");
			buffer.append("<img src='/mvc/images/left.png' width='15'></a> ");
		}
		for(int i = page.getPageStart(); i <= page.getPageEnd();i++) {
			if(i == curPage)
				buffer.append("<a href='/mvc/news.do?pgNum="+i+linkStr+"'"+" style='font-weight:bold;'>"+i+"</a> ");
			else
				buffer.append("<a href='/mvc/news.do?pgNum="+i+linkStr+"'"+">"+i+"</a> ");
		}
		if(page.isNextData()) {
			buffer.append("<a href='/mvc/news.do?pgNum=");
			buffer.append((page.getPageEnd()+1)+linkStr+"'>");
			buffer.append(" <img src='/mvc/images/right.png' width='15'></a>");
		}
		return buffer.toString();		
	}

	public List<NewsVO> listAll(int curPage) {
		Statement stmt = null;
		ResultSet rs = null;
		List<NewsVO> list = new ArrayList<NewsVO>();
		Connection conn = getConnect();
		try {
			stmt = conn.createStatement();			
			PagingControl page = new PagingControl(5,5,getCount(), curPage);		
			String sql =  "select * from "
					+"(select id, writer, title, content, writedate, viewcount, rownum rnum from "
					+"(select * from news order by writedate desc)) "
					+ "where rnum between "+page.getWritingStart()+" and "+page.getWritingEnd();
			rs = stmt.executeQuery(sql);			
			list = makeList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}
		return list;
	}

	public List<NewsVO> listWriter(String writer, int curPage) {
		Statement stmt = null;
		ResultSet rs = null;
		List<NewsVO> list = null;
		Connection conn = getConnect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from news where writer = '"+writer+"'");
			rs.next();
			int count = rs.getInt(1);
			PagingControl page = new PagingControl(5,5,count, curPage);
			String sql =  "select * from "
					+"(select id, writer, title, content, writedate, viewcount, rownum rnum from "
					+"(select * from news where writer =  '"+writer+"' order by writedate desc ) ) "
					+ "where rnum between "+page.getWritingStart()+" and "+page.getWritingEnd();
			rs = stmt.executeQuery(sql);
			list = makeList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}
		return list;
	}

	public List<NewsVO> listSort(String sortColumn, int curPage) {
		Statement stmt = null;
		ResultSet rs = null;
		List<NewsVO> list = null;
		Connection conn = getConnect();
		try {
			PagingControl page = new PagingControl(5,5,getCount(), curPage);
			
			String sql =  "select * from "
					+"(select id, writer, title, content, writedate, viewcount, rownum rnum from "
					+"(select * from news order by "+sortColumn+" asc)) "
					+ "where rnum between "+page.getWritingStart()+" and "+page.getWritingEnd();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			list = makeList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}
		return list;
	}
	public List<NewsVO> search(String key, String searchType, int curPage) {
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = getConnect();
		List<NewsVO> list = null;
		String searchExpr = "";
		if (searchType.equals("content")) {
			searchExpr = " content like '%" + key + "%'";
		} else if (searchType.equals("title")) {
			searchExpr = " title like '%" + key + "%'";
		} else {
			searchExpr = " title like '%" + key + "%'" + " OR content like '%" + key + "%'";
		}
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from news where "+searchExpr);
			rs.next();
			int count = rs.getInt(1);
			if (count > 0) {
				PagingControl page = new PagingControl(5,5,count, curPage);
				String sql = "select id, writer, title, content, writedate, viewcount, rnum from ( "
					+ "select id, writer, title, content, writedate, viewcount, rownum rnum from news where "
					+ searchExpr 
					+ ") where rnum between "+page.getWritingStart()+" and "+page.getWritingEnd();
				rs = stmt.executeQuery(sql);
				list = makeList(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}
		return list;
	}
	
	public NewsVO listOne(int id) {
		Statement stmt = null;
		ResultSet rs = null;
		NewsVO vo = new NewsVO();
		Connection conn = getConnect();
		try {
			stmt = conn.createStatement();
			rs = stmt
					.executeQuery("select  id, writer, title, content, writedate, viewcount from news where id =" + id);
			if (rs.next()) {
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWriteDate(rs.getDate(5).toString());
				vo.setViewCount(rs.getInt(6));
			}
			stmt.executeUpdate("update news set viewcount = viewcount+1 where id = " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}
		return vo;
	}

	private List<NewsVO> makeList(ResultSet rs) throws SQLException {
		ArrayList<NewsVO> list = null;
		if (rs.next()) {
			list = new ArrayList<NewsVO>();
			do {
				NewsVO vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setWriteDate(rs.getDate(5).toString());
				vo.setViewCount(rs.getInt(6));
				list.add(vo);
			} while (rs.next());
		}
		return list;
	}

	private void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public class PagingControl {
		public int lineCnt = 0;
		public int pageCnt = 0; 
		public int postCnt = 0;
		public int pgNum = 0;
		public PagingControl(int lineCnt, int pageCnt, int postCnt, int pgNum) {
			this.lineCnt = lineCnt;
			this.pageCnt = pageCnt;
			this.postCnt = postCnt;
			this.pgNum = pgNum;
		}
		public int getPageCount() {
			return ((postCnt - 1) / lineCnt) + 1;
		}
		public int getPageStart() {
			return ((pgNum - 1) / pageCnt) * pageCnt + 1;
		}
		public int getPageEnd() {
			return Math.min(getPageStart() + pageCnt - 1, getPageCount());
		}
		public boolean isPreData() {
			return getPageStart() != 1;
		}
		public boolean isNextData() {
			return getPageEnd() < getPageCount();
		}
		public int getWritingStart() {
			return getWritingEnd() - lineCnt + 1;
		}
		public int getWritingEnd() {
			return pgNum * lineCnt;
		}
	}
}

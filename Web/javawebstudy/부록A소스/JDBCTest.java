import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	public JDBCTest() {
		super();
	}

	public void selectEmp() throws SQLException {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE",
					"jdbctest","jdbctest");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery("SELECT * FROM EMP ORDER BY NUM ASC");
			
			System.out.println("사원번호        이름           부서            입사점수");
			System.out.println("------------------------------");
			while(rs.next()){
				System.out.print(rs.getInt("NUM")+"\t");
				System.out.print(rs.getString("NAME")+"\t");
				System.out.print(rs.getString("DEPT")+"\t");
				System.out.println(rs.getDouble("SCORE"));
			}
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			rs.close();
			stmt.close();
			conn.close();
		}		
	}

	public void insertEmp1(String name, String dept, double score) throws SQLException {
		Connection conn=null;
		Statement stmt=null;
		int n;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE",
					"jdbctest","jdbctest");
			
			String sql="INSERT INTO EMP(NUM,NAME,DEPT,SCORE) VALUES(EMP_SEQ.NEXTVAL,'" 
			            + name + "','" + dept + "'," + score +")"; 
			stmt=conn.createStatement();
			n=stmt.executeUpdate(sql);
			if(n > 0){
				System.out.println(n + "행의 데이터를 추가했습니다.\n");
				conn.commit();
			}
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			stmt.close();
			conn.close();
		}			
	}

	public void insertEmp2(String name, String dept, double score) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int n;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE",
					"jdbctest","jdbctest");
			
			String sql="INSERT INTO EMP(NUM,NAME,DEPT,SCORE) VALUES(EMP_SEQ.NEXTVAL,?,?,?)"; 
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, dept);
			pstmt.setDouble(3, score);
			n=pstmt.executeUpdate();
			if(n > 0){
				System.out.println(n + "행의 데이터를 추가했습니다.\n");
				conn.commit();
			}
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			pstmt.close();
			conn.close();
		}
	}

	public void updateEmp(String dept, double score, int num) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int n;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE",
					"jdbctest","jdbctest");
			
			String sql="UPDATE EMP SET DEPT=?, SCORE=? WHERE NUM <= ?"; 
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dept);
			pstmt.setDouble(2, score);
			pstmt.setInt(3, num);
			n=pstmt.executeUpdate();
			if(n > 0){
				System.out.println(n + "행의 데이터를 수정했습니다.\n");
				conn.commit();
			}
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			pstmt.close();
			conn.close();
		}
	}

	public void deleteEmp(String dept) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int n;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE",
					"jdbctest","jdbctest");
			
			String sql="DELETE FROM EMP WHERE DEPT=?"; 
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,dept);
			n=pstmt.executeUpdate();
			if(n > 0){
				System.out.println(n + "행의 데이터를 삭제했습니다.\n");
				conn.commit();
			}
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			pstmt.close();
			conn.close();
		}
	}
}

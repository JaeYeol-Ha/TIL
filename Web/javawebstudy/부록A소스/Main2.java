import java.sql.SQLException;

public class Main2 {
	public static void main(String[] args) throws SQLException {
		//Statement로 insert하기
		JDBCTest ob=new JDBCTest();
		ob.insertEmp1("고길동","개발부",60.5);
		ob.selectEmp();
	}
}

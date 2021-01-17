import java.sql.SQLException;

public class Main3 {
	public static void main(String[] args) throws SQLException {
		//PreparedStatement로 insert하기
		JDBCTest ob=new JDBCTest();
		ob.insertEmp2("마이콜","영업부",55.5);
		ob.selectEmp();
	}
}

import java.sql.SQLException;

public class Main5 {
	public static void main(String[] args) throws SQLException {
		//delete하기
		JDBCTest ob=new JDBCTest();
		ob.deleteEmp("개발부");
		ob.selectEmp();
	}
}

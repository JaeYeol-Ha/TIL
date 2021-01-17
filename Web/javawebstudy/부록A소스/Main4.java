import java.sql.SQLException;

public class Main4 {
	public static void main(String[] args) throws SQLException {
		//update하기
		JDBCTest ob=new JDBCTest();
		ob.updateEmp("경리부",100.0,2);
		ob.selectEmp();
	}
}
 
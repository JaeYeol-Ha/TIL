import java.sql.SQLException;

public class Main3 {
	public static void main(String[] args) throws SQLException {
		//PreparedStatement�� insert�ϱ�
		JDBCTest ob=new JDBCTest();
		ob.insertEmp2("������","������",55.5);
		ob.selectEmp();
	}
}

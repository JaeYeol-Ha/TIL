import java.sql.SQLException;

public class Main5 {
	public static void main(String[] args) throws SQLException {
		//delete�ϱ�
		JDBCTest ob=new JDBCTest();
		ob.deleteEmp("���ߺ�");
		ob.selectEmp();
	}
}

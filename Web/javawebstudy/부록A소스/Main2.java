import java.sql.SQLException;

public class Main2 {
	public static void main(String[] args) throws SQLException {
		//Statement�� insert�ϱ�
		JDBCTest ob=new JDBCTest();
		ob.insertEmp1("��浿","���ߺ�",60.5);
		ob.selectEmp();
	}
}

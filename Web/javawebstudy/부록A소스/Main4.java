import java.sql.SQLException;

public class Main4 {
	public static void main(String[] args) throws SQLException {
		//update�ϱ�
		JDBCTest ob=new JDBCTest();
		ob.updateEmp("�渮��",100.0,2);
		ob.selectEmp();
	}
}
 
package dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=UTC&verifyServerCertificate=false&useSSL=false";
	private static String dbUser = ""; //input dbUser
	private static String dbpasswd = "";  // input dbPasswd

	
	private static String url = "jdbc:mysql://localhost:3306/connectdb?useUnicode=true&characterEncoding=utf8&useSSL=false";
	private static String username = "connectuser";
	private static String password = "connect123!@#";
	
	public static Connection getConnection() throws SQLException {
//		return DriverManager.getConnection(dburl, dbUser, dbpasswd);
		return DriverManager.getConnection(dburl, username, password);
	}
}

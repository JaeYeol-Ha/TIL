package kr.or.connect.jdbcexam.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.connect.jdbcexam.dto.Role;

public class RoleDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private static String user = "connectuser";
	private static String password = "connect123!@#";

	public List<Role> getRoles() {
		List<Role> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "SELECT description, role_id FROM role order by role_id desc";
		try (Connection conn = DriverManager.getConnection(dburl, user, password);
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				String description = rs.getString(1);
				int id = rs.getInt("role_id");
				Role role = new Role(id, description);
				list.add(role); // list에 반복할때마다 Role 인스턴스를 생성하여 list에 추가한다.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int addRole(Role role) {
		int insertCount = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO role (role_id, description) VALUES (?,?)";
		try (Connection conn = DriverManager.getConnection(dburl, user, password);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());
			insertCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertCount;
	}

	public Role getRole(Integer roleId) {
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, user, password);
			String sql = "SELECT description, role_id FROM role WHERE role_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId); // sql의 ? 1번째 자리에 roleId를 입력
			rs = ps.executeQuery();
			if (rs.next()) {
				String description = rs.getString(1); // 컬럼의 1번째 값을 받아오겠다.
				int id = rs.getInt("role_id"); // role_id를 받아오겠다.
				role = new Role(id, description);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return role;
	}
}

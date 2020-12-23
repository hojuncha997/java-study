package test.mariadb;

import java.sql.DriverManager;

public class ConnectionTest {
	public static void main(String[] args) {
		Connection conn =null;
		
		
		try {
			
			//1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mysql://192.168.1.218:3307/webdb?characterEncoding=utf9"
			conn = DriverManager.getConnection(url, "webdb", "webdb";
		
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패" + e );
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		
		} finally {
			try {
				if(conn != null)
			}
			conn.close;
		}
	}

}

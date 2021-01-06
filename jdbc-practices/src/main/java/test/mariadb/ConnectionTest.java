package test.mariadb;
//db 연결

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//1.jdbc driver loading
			Class.forName("org.mariadb.jdbc.Driver");
		
			//2. 연결하기
			String url = "jdbc:mysql://192.168.1.218:3307/webdb?characterEncoding=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			// (url, 디비이름, 비밀번호)
			System.out.println("연결 성공!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				//3. 자원정리
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

package test.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class insertTest {

	public static void main(String[] args) {

		for (int i = 1; i <= 20; i++) {
			BookVo vo = new BookVo();
			vo.setTitle("책" + i);
			vo.setAuthor("저자" + i);
			vo.setPrice(2000*i);

			boolean result = insert(vo);
			if (result) { // result가 true이면
				System.out.println("성공!");
			}
		}
	}

	public static boolean insert(BookVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1.jdbc driver loading
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://192.168.1.218:3307/webdb?characterEncoding=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			// (url, 디비이름, 비밀번호)
			System.out.println("연결 성공!");

			// 3. SQL 준비
			String sql = " insert" + 
					" into book" + 
					" values(null, '?', '?', ? )"; //?자라에 값을 바인딩
			pstmt = conn.prepareStatement(sql);
			
			// 4. 바인딩
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getAuthor());
			pstmt.setInt(3, vo.getPrice());
			
			// 5. sql문 실행
			
			int count = pstmt.executeUpdate(); 

			result = (count == 1);

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 3. 자원정리
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}








/*이렇게도 할 수 있음
 * 
 * //3. Statement 객체 생성 stmt = conn.createStatement();
 * 
 * // 4. sql문 실행 String sql = " insert" + " into book" + " values(null, '" +
 * vo.getTitle() + "', '" + vo.getAuthor() + "', " + vo.getPrice() + " )"; // 앞칸
 * 띄워 줘야함. 한줄되면 붙기 때문 int count = stmt.executeUpdate(sql);
 * 
 * result = (count == 1);
 * 
 */






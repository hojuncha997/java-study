/*클라이언트 통신

1. 소켓 생성
2. connect
3. write
4. read
5. close
*/

package test;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPClient {
	private static final String SERVER_IP ="127.0.0.1";
	private static final int SERVER_PORT =5000;
	
	public static void main(String[] args) {
		Socket socket = null;
		try {

		//1. 소켓 생성
			socket = new Socket();
		
		//2. 서버연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			System.out.println("[client] connected!");
		//3. IOStream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
		//4. 쓰기
			String data = "Hello World";
			os.write(data.getBytes("UTF-8"));
			
		//5. 읽기
			
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer);
			
			if(readByteCount == -1) {
				///server가 정상종료
				System.out.println("[client] closed by server");
				return;
			}
			
			data = new String(buffer, 0, readByteCount, "UTF-8");
			System.out.println("[client] error" + data);
			
			
		} catch (IOException e) {
			System.out.println("[client] error:" + e);
		} finally {
			try {
				if(socket!=null && !socket.isClosed())
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
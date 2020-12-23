/*서버 쪽 통신 단계

1. socket 생성(리슨-커넥트 용)
2. 바인딩(소켓에 inetSocketAddress묶기)
3. accept 후 새로운 소켓 생성(직접통신용)
4. read
5. write
6. close
*/


package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();

			/*
			 * 2. 바인딩(binding -소켓에 주소(아이피+포트)를 묶어 Socket Address로 만는 작업) Socket Address = IP
			 * Address + Port 이렇게 해야 서버에서 포트를 연다. 이 작업은 InetSocketAddress를 사용한다.
			 * InetAddress와 헷갈릴 수 있는데, InetAddress는 IP address를 매핑한 값만 가지고 있을 뿐 port번호를 가지고
			 * 있지 않다. 따라서 IP address와 port번호 모두를 가지고 있는 InetSocket Address를 사용하는 것이다
			 * 
			 * InetSocketAddress^[InetAddress^[IP address] + port]
			 */

			InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 5000);
			// new InetSocketAddress()안에 들어갈 파라메터로 new InetAddress를 넣어도 될 것이다.(그런데 포트번호가
			// 없는데...)
			// 그러나 좀더 확실하게 하기 위해서 IP address와 port 번호를 넣어준다. 이것이 문법적으로도 맞다.

			serverSocket.bind(inetSocketAddress); //***바인딩**
			// 위에 만든 소켓에 방금 만든 InetSocketAddress를 묶어준 것이다. 아직 listening하는 단계는 아니다.
			// (5000포트 사용하는 socket)----( S E R V E R )

			// 3. accept
			Socket socket = serverSocket.accept(); // blocking. 프로그램이 실행되며 내려오다가 여기서 멈춘다.
			// 아직 클라이언트로부터 커넥트가 이루어지지 않았기 떄문이다. 밑으로 내려오려면 connetct로
			// 찔러줘야 한다. 클라이언트를 아직 만들지는 않았지만 telnet으로 서버를 connect해서 테스트 할 수 있다.

			// 클라이언트가 connect했다면

			// 만약 서버가 클라이언트의 connect를 accept하면 통신용 소켓(Socket socket)을 하나 반환한다.
			// 이것은 클라이언트와의 직접 통신을 담당하기 위해 만드는 것이다. 이것은 위에서 만들었던 ServerSocket과는 차이가 있다.
			// Server Socket은 클라이언트의 connec 요청을 기다리면서 그에 대한 수락을 담당하고 소켓을 반환할 뿐이기 때문이다.
			// 바로 이것 떄문에 스레드가 필오하다.

			InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			// getRemoteSocketAddress()는 소켓이 연결돼 있는 엔드포인트의 주소를 반환한다.
			// 그 주소는 InetSocketAddress이다. 만약연결돼 있지 않다면 null을 반환한다.

			InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
			// 뽑아낸 InetSocketAddress에서 다시 InetAddress를 뽑아낸다.

			String remoteHostAddress = remoteInetAddress.getHostAddress();
			// InetAddress에서 다시 IP주소를 뽑아낸다. 이 주소가 바로 원격지의 클라이언트의 주소가 된다.

			int remotePort = remoteInetSocketAddress.getPort();
			// 소켓어드레스로부터 포트번호를 뽑아낸다. InetAddress가 아니다. InetSocektAddress이다.

			System.out.println("[server] connected by clinet[" + remoteHostAddress + ":" + remotePort + "]");
			// 이제 서버에 연결되면 아이피 주소와 포트가 나온다.

			try {
			
			// 4. IOStream 받아오기 /

			InputStream is = socket.getInputStream(); //이 소켓에 대한 인풋스트림을 반환함
			OutputStream os = socket.getOutputStream();//이 소켓에 대한 아웃풋스트림을 반환함

				while (true) {
	
					// 5. 데이터 읽기
	
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer); // 클라이언트로부터 입력 없는 동안은 block 상태
					//inputstream.read(b)인풋스트림으로부터 받은 바이트를 바이트 배열에 담고 그 개수를 정수로 반홤함.
	
					if (readByteCount == -1) {
						// 클라이언트가 소켓을 정상적으로 종료
						System.out.println("[server] closed by client");
						break; //서버도 끊음
					}
					
					String data = new String(buffer, 0, readByteCount,"UTF-8");
					//버퍼에서 0부터 읽은 바이트만큼 utf-8로 인코딩해라.
					
					System.out.println("[server] received:" + data);
					// 그것을 출력
					
					//6. 데이터 쓰기
					os.write(data.getBytes("utf-8"));
					//바이트로 받아서 utf8로 인코딩.getByte()는 string을 받아 바이트 배열을 반환한다.
					//write는 byte 배열을 받아서 outputStream에 나타낸다. 
					
					
					
				}
			} catch(IOException e) { //서버 소켓 익셉션
				System.out.println("[server] error:" + e);
			} finally {
				try {
					if(socket !=null && socket.isClosed()) {
					socket.close();//클라이언트 소켓과 직접 통신하는 소켓
					}
				} catch(IOException e) {
					e.printStackTrace();
				}
				
			}

		} catch (IOException e) { //서버 익셉션
			System.out.println("[server] error:" + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ChatServer {
	
	ServerSocket serverSocket = null;
	
	
	try {
		serverSocket = new ServerSocket();
		String localhost = "127.0.0.1";
		serverSocket.bind( new InetSocketAddress( localhost, PORT ) );
		System.out.println("bind " + localhost + ":" + PORT);
		
		while(true) {
			//5. 데이터 읽기
			String data = br.readLine();
			
			if(data == null){
				// client가 소켓을 정상 종료
				System.out.println("[server] closed by client");
				break;
			}
			
			System.out.println("[server] received:" + data);
			
			//6. 데이터쓰기
			pw.println(data);
		}
		
	}
	
	// 1. 서버 소겟 생성
	serverSocket = new ServerSocket();
				
	// 2. 바인딩
	String hostAddress = InetAddress.getLocalHost().getHostAddress();
	serverSocket.bind( new InetSocketAddress( hostAddress, PORT ) );			
	System.out.println( "연결 기다림 " + hostAddress + ":" + PORT );

	// 3. 요청 대기 
	while( true ) {
	   Socket socket = serverSocket.accept();
	   new ChatServerTread( socket ).start();
	}


	
	
	
	
	
	public static final int PORT = 3000;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			//1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			//2. 바인딩(binding): Socket Address(IP Address + Port)
			serverSocket.bind(new InetSocketAddress("127.0.0.1", PORT));

			//3. accept
			Socket socket = serverSocket.accept();
			
			InetSocketAddress remoteInetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
			String remoteHostAddress = remoteInetAddress.getHostAddress();
			int remotePort = remoteInetSocketAddress.getPort();
			System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remotePort + "]");
			
			try {
				//4. IOStream 생성(받아오기)
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
				
				while(true) {
					//5. 데이터 읽기
					String data = br.readLine();
					
					if(data == null){
						// client가 소켓을 정상 종료
						System.out.println("[server] closed by client");
						break;
					}
					
					System.out.println("[server] received:" + data);
					
					//6. 데이터쓰기
					pw.println(data);
				}
			} catch(SocketException e) {
				// client가 비정상 종료
				System.out.println("[server] suddenly closed by client");
			} catch(IOException e) {
				System.out.println("[server] error:" + e);
			} finally {
				try {
					if(socket != null && !socket.isClosed()) {
						socket.close();
					}
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			System.out.println("[server] error:" + e);
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
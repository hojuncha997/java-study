package echo;

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

public class EchoServer {
	public static final int PORT = 7000;
	
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
			//
			/*
			 * while(true) { Socket socket = serverSocket.accept(); new
			 * EchoServerReceiveThread().start(); }
			 */
			/* 쓰레드에 붙여 넣을 것임
			 * try {
				//4. IOStream 생성(받아오기)
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
				//true는 자동으로 flush 하라는 뜻임. printwrite메소드는 상당히 편리함. 알아둘 것.
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
					pw.println(data); //개행을 붙인 것임
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
			}*/
			
			
			
			
			
			try {
				//4. IOStream 생성(받아오기)
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
				//true는 자동으로 flush 하라는 뜻임. printwrite메소드는 상당히 편리함. 알아둘 것.
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
					pw.println(data); //개행을 붙인 것임
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
package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import chat.ChatServer;
import thread.DigitThread;

public class ChatClient {
	
	
	
	
	
	Scanner scanner = null;
	Socket socket = null;
	try {
	   //1. 키보드 연결

	   //2. socket 생성
		socket = new Socket();
	   //3. 연결
		socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
		System.out.println("[client] connected!");
	   //4. reader/writer 생성
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
		
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		
		String data = scanner.nextLine();
		os.write(data.getBytes("UTF-8"));
		
		
		byte[] buffer = new byte[256];
		int readByteCount = is.read(buffer);

		if(readByteCount == -1) {
			// server 정상종료
			// server 정상 종료
			System.out.println("[client] closed by server");
			return;
		}

		data = new String(buffer, 0, readByteCount, "UTF-8");
		System.out.println("[clinet] received:" + data);

	   //5. join 프로토콜
	   System.out.print("닉네임>>" );
	   String nickname = scanner.nextLine();
	   printWriter.println( "join:" + nickname );
	   printWriter.flush();

	   //6. ChatClientReceiveThread 시작

	   //7. 키보드 입력 처리
	   while( true ) {
	      System.out.print( ">>" );
	      String input = scanner.nextLine();
					
	      if( "quit".equals( input ) == true ) {
	          // 8. quit 프로토콜 처리
	          break;
	      } else {
	          // 9. 메시지 처리
	    	  
	    	  String message = br.readLine();
				
				if(message == null){
					// server가 소켓을 정상 종료
					System.out.println("[client] closed by server");
					break;
				}
	      }
	   }
	} catch(SocketException e) {
		// server 비정상 종료
		System.out.println("[clinet] suddenly closed by server");
	} catch( IOException ex ) {
	       System.out.println( "error:" + ex );
	} finally {
	      //10. 자원정리
		try {
			if(scanner != null) {
				scanner.close();
			}
			if(socket != null && !socket.isClosed())
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	


}

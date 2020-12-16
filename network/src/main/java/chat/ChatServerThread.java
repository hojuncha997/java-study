package chat;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServerThread extends Thread {
	private Socket socket;
	private String nickname;
	
	public ChatServerThread( Socket socket ) {
		this.socket = socket;
	}


	@Override
	public void run() {
		
		//1. Remote Host Information
		
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
		String remoteHostAddress = remoteInetAddress.getHostAddress();
		int remotePort = remoteInetSocketAddress.getPort();
		System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remotePort + "]");
		
		try {
			
			//2. 스트림 얻기
			BufferedReader bufferedReader = 
			     new BufferedReader( new InputStreamReader( socket.getInputStream(), StandardCharsets.UTF_8 ) );
			PrintWriter printWriter = 
			     new PrintWriter( new OutputStreamWriter( socket.getOutputStream(), StandardCharsets.UTF_8 ), true );
			
			
			//3. 요청 처리 			
			while( true ) {
			   String request = bufferedReader.readLine();
			   if( request == null ) {
			      System.out.println( "클라이언트로 부터 연결 끊김" );
			      break;
			   }

			   // 4. 프로토콜 분석
			   
			   String[] tokens = request.split( ":" );
				
			   if( "join".equals( tokens[0] ) ) {

			      doJoin( tokens[1], printWriter );

			   } else if( "message".equals( tokens[0] ) ) {
			      
			      doMessage[ tokens[1] );

			   } else if( "quit".equals( tokens[0] ) ) {
			      
			      doQuit();

			   } else {

			      ChatServer.log( "에러:알수 없는 요청(" + tokes[0] + ")" );
			   }

			

			
			
		}catch
	}


private void doJoin( String nickName, Writer writer ) {
   this.nickname = nickName;
   /* writer pool에  저장 */ 
}


List<Writer> listWriters = new ArrayList<Writer>();


List<Writer> listWriters;


new ChatServerThread( socket, listWriters ).start();


public ChatServerTread( Socket socket, List<Writer> listWriters ) {
   this.socket = socket;
   this.listWriters = listWriters;
}



private void doJoin( String nickName, Writer writer ) {
   this.nickname = nickName;

   /* writer pool에  저장 */
   addWriter( writer );
}
	
private void addWriter( Writer writer ) {
   synchronized( listWriters ) {
      listWriters.add( writer );
   }
}





private void broadcast( String data ) {

synchronized( listWriters ) {

  for( Writer writer : listWriters ) {
PrintWriter printWriter = (PrintWriter)writer;
printWriter.println( data );
printWriter.flush();
  }

}

}


private void doJoin( String nickName, Writer writer ) {
this.nickname = nickName;
	
String data = nickName + "님이 참여하였습니다."; 
broadcast( data );
	
/* writer pool에  저장 */
addWriter( writer );

// ack
printWriter.println( "join:ok" );
printWriter.flush();
}


private void doMessage( String message ) {

    String message = ( "[" + nickName + "] " + message);
	broadcast(message);

}


private void doQuit(  Writer writer ) {
removeWriter( writer );
	
String data = nickname + "님이 퇴장 하였습니다."; 
broadcast( data );
}

private void removeWriter( Writer writer ) {

/* 잘 구현 해보기 */
	 synchronized( listWriters ) {
	      listWriters.remove( writer );
	 }
	
}


if( request == null ) {
    ChatServer.log( "클라이언트로 부터 연결 끊김" );
    doQuit( printWriter );
    break;
}


		}		
		
		
	

	
}

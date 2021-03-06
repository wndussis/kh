package kh.java.network.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {
	
	public static final String SERVER_IP = "khmclass.iptime.org";
	public static final int SERVER_PORT = 7777;

	public static void main(String[] args) {
		new ChatClient().init();

	}
	
	private void init() {
		
		try {
			//1. 소켓 생성 동시에 연결요청
			Socket socket = new Socket(SERVER_IP , SERVER_PORT);
			
			//2. 소켓용 입출력스트림 준비
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			
			
			//3. 서버통신
//			System.out.println("서버 : " + br.readLine()); // 서버 웰컴메세지
			
			//4. 채팅
			String data = " ";
			Scanner sc = new Scanner(System.in); // 사용자 키보드 입력
			while((data = br.readLine()) != null) {  // null 이 아니라면 계속 반복
				System.out.println("서버 : " + data);
			    System.out.println("클라이언트 : ");
			    String msg = sc.nextLine(); // 메세지 입력받는것
			    pw.println(msg);
			    pw.flush();
			    
			    if("exit".equals(msg)) { // 사용자가 exit 를 입력했다면
			    	System.out.println("채팅프로그램을 종료합니다.");
			    	break;
			    }
			}
			
			
		} catch (UnknownHostException e) {
				e.printStackTrace();
		} catch (IOException e) {	
			e.printStackTrace();
		}  
	
		
		
	}

}

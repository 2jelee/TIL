package ex04.net.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {
	public static void main(String[] args) {
		//그릇만들기			>> reader, writer는 Character 단위로 읽는다.
		BufferedReader br = null, stin = null; //standard inner?
		BufferedWriter bw = null;
		//소켓 2개 생성
		ServerSocket server = null;		//socket1
		Socket client = null; 			//socekt2
		
		System.out.println("[Server] 안녕하세요. 저는 Server입니다.");
		
		try {
			server = new ServerSocket(9999);	//Server는 port번호로 소켓 생성하면 된다.
			client = server.accept();	//서버가 켜지고 응답대기(클라 접속 전까지), 클라이언트 소켓
			
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			//키보드로부터 입력 스트림
			stin = new BufferedReader(new InputStreamReader(System.in)); // 표준 입력 : System.in
			
			//클라이언트로부터 출력 스트림
			bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
			String inputMessage;	//문자열 저장할 변수
			//대화를 주고받는데, "exit"라는 문자가 올 때까지!
			while(true) {
				inputMessage = br.readLine();	//읽어들이기
				
				if(inputMessage.equalsIgnoreCase("exit")) {
					break;
				}
				System.out.println(inputMessage);
				String outputMessage = stin.readLine();
				//써라 write
				bw.write("2jelee Server > " + outputMessage + "\n");
				bw.flush();		//비워라 => 내보내라
			}// end of while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//작은 것 부터 닫기
			try {
				client.close();
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
} 
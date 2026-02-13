package ex04.net.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientEx {
	public static void main(String[] args) {
		//그릇만들기			>> reader, writer는 Character 단위로 읽는다.
		BufferedReader br = null, stin = null; //stin : standard in >> 표준입력
		BufferedWriter bw = null;
		Socket client = null; 			//socket 1개로 충분  << client
		
		try {
			//client 측은 IP주소와 port번호 필요하므로
			client = new Socket("localhost", 9999);	// client는 ip와 port 번호로 생성됨  //ServerEx.java의 24번째 줄 만난다.
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			stin = new BufferedReader(new InputStreamReader(System.in)); //표준입력(System.in)으로 읽겠다. >> 표준입력 그릇
			bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
			String outputMessage;	//문자열을 저장할 변수
			
			while(true) {
				System.out.println("Message input : ");
				outputMessage = stin.readLine();
				
				if(outputMessage.equalsIgnoreCase("exit")) {  //ServerEx.java의 39번째 줄 만난다.
					bw.write(outputMessage); //쓰고
					bw.flush();				 //네트워크를 통해 보내준다.
											 //flush : 버퍼 비우기        >> 만약 br.flush면 읽는거 비우겠다.
					break;
				}
				
				bw.write("Client > " + outputMessage + "\n");
				bw.flush(); 				 //flush : 버퍼 비우기 
				
				String inputMessage = br.readLine();
				System.out.println(inputMessage);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				System.out.println("Server와의 채팅 중 오류 발생");
			}
		}
	}
}

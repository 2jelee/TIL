package ex05.net.udp;

import java.io.BufferedOutputStream; 
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServer {
	public static void main(String[] args) {
		DatagramPacket dp = null;
		DatagramSocket ds = null;
		DataOutputStream dos = null;
//		DataInputStream dis = null;
		
		int port = 5000;
		String str;
		File file = null; //객체 생성
		
		try {
			System.out.println("--- UDP File Server ---");
			ds = new DatagramSocket(port); //현재 대기상태임
			
			while(true) {
				dp = new DatagramPacket(new byte[65536], 65536); //				byte[65536] : 엑셀 크기
				//수신
				ds.receive(dp);
				
				//0번부터 시작해서 data의 크기만큼 , trim 공백제거
				str = new String(dp.getData(), 0, dp.getLength()).trim();
				
				if(str.equalsIgnoreCase("start")) {
					System.out.println("[SYSTEM] 전송되고 있습니다.");
//					file = new File("test.txt"); 	//error
					file = new File("C:\\00DouZone_th2\\1_Java\\workspace\\day15_network\\test.txt");
					
					//쓰기(출력) 객체 생성
					//DataOutputStream을 이용해 출력 -> BufferedOutputStream을 이용해 FileOutputStream의 file을  
					dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
				} else if(str.equalsIgnoreCase("end")) {
					System.out.println("end");
					break;
				} else if(file!=null) {
					System.out.println(str);
					dos.write(dp.getData(), 0, dp.getLength());
				}
			}
		} catch (Exception e) {
			//문제 있으면 네가 알아서 처리해라.
			e.printStackTrace();
		} finally {
			try { dos.close(); } catch (Exception e) { e.printStackTrace(); } 
		}
	}
}

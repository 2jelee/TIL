package ex05.net.udp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramClient {

	public static void main(String[] args) {
		DatagramPacket dp = null;
		DatagramSocket ds = null; 
		//읽기 위한 dis, br
		DataInputStream dis = null;
		BufferedReader br = null;
		
		int port = 5000;
		String str;
		byte[] b;	//byte 배열 => 그렇지 않으면 하나하나 보내야된다.
		
		try {
			System.out.println("--- File UDP Client ---");
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("전송 대상(server ip) : ");
			String ipAddress = br.readLine();
			System.out.println("전송 파일(파일명.확장자) :");
			String fileName = br.readLine(); // C:\\00DouZone_th2\\1_Java\\workspace\\day15_network\\test.txt
			
			File file = new File(fileName);
			if( !file.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				System.exit(0);
			} 
			
			ds = new DatagramSocket();
			InetAddress ip = InetAddress.getByName(ipAddress);
			str = "start";
			b = str.getBytes();
			
			dp = new DatagramPacket(b, b.length, ip, port); //생성
			ds.send(dp); //송신
			
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
			b = new byte[65536];
			
			while(true) {
				int count = dis.read(b, 0, b.length);
				if(count==-1) break;
				dp = new DatagramPacket(b, count, ip, port);
				ds.send(dp);
			}
			
			str = "end";
			b = str.getBytes();
			
			dp = new DatagramPacket(b, b.length, ip, port);
			ds.send(dp); //송신
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { br.close(); dis.close(); } catch (Exception e) { e.printStackTrace(); } 
		}
	}
}

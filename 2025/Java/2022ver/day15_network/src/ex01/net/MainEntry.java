package ex01.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainEntry {
	public static void main(String[] args) {
		String host = "192.168.0.19";	 //나의 아이피 주소를 넣겠다.
//		String host = "127.0.0.1";		 //이또한 나다.
		
		try {
			InetAddress[] addr = InetAddress.getAllByName(host);	// getAllByName >> throw.. 예외발생
			for (InetAddress item : addr) {
				System.out.println(item.getCanonicalHostName());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}	
	}
}

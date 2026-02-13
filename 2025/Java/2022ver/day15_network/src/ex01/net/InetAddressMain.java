package ex01.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strUrl = null;
		InetAddress[] addr;		//숫자로 되어있는 
		
		System.out.println("site address : ");
		try {
			strUrl = br.readLine();	//예외 발생
			addr = InetAddress.getAllByName(strUrl);		// getAllByName : ip addresss 또는 domain name 으로든지 주소를 가져옴
//			addr = InetAddress.getAllByName("www.sw.or.kr");
//			addr = InetAddress.getAllByName("223.130.195.200");
			
			for (int i = 0; i < addr.length; i++) {
				System.out.println(addr[i]);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

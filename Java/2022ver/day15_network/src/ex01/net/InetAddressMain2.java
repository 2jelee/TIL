package ex01.net;
 
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain2 {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();		// 예외처리 throws
		System.out.println("로컬 호스트 이름 : " + addr.getHostName());
		System.out.println("로컬 호스트 IP주소 : " +addr.getHostAddress());
		
		System.out.println();
		addr = InetAddress.getByName("www.naver.com");
		
		System.out.println("로컬 호스트 이름 : " + addr.getHostName());
		System.out.println("로컬 호스트 IP주소 : " +addr.getHostAddress());
		
		byte[] address = new byte[4];
//		address[0] = 211;		//이렇게 쓰면 int로 인식
		address[0] = (byte)211;	//byte로 바꾸기 위해 명시적 형변환 (큰->작)
		address[1] = (byte)249;
		address[2] = (byte)220;
		address[3] = (byte)24;

		addr = InetAddress.getByAddress(address);
		System.out.println();
		System.out.println("Daum 호스트 이름 : " + addr.getCanonicalHostName());
		System.out.println("Daum 호스트 이름 : " + addr.getHostName());
		System.out.println("Daum 호스트 IP 주소 : " + addr.getHostAddress());
		
		InetAddress[] arr;
		arr = InetAddress.getAllByName("www.google.com");
		System.out.println();
		for (InetAddress item : arr) {
			System.out.println("Google 호스트 이름 : " + item.getHostName());
			System.out.println("Google 호스트 IP 주소 : " + item.getHostAddress());
		}
	}
}

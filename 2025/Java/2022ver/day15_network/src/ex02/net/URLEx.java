package ex02.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL; 

public class URLEx {
	public static void main(String[] args) throws MalformedURLException, IOException {
		//생성자 자체에서도 예외발생
		URL google = new URL("http://www.google.com");		//반드시 http://를 써주자 	// -> 예외 위임 throws
		
		BufferedReader br = new BufferedReader(new InputStreamReader(google.openStream()));	//예외발생 -> 예외 위임 throws
		
		String inputLine;
		
		while ((inputLine = br.readLine()) != null) { //예외발생
			System.out.println(inputLine);
		}
		br.close();
	}
}

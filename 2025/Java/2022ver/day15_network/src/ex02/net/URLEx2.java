package ex02.net;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class URLEx2 {
	public static void main(String[] args) throws MalformedURLException, IOException { 
		/*
		https://www.google.com
			/search
			?q=metamong
			&oq=metamong&aqs=chrome..69i57j0i512l3j0i30j0i10i30j0i30l2j0i5i10i30l2.1950j0j15&sourceid=chrome&ie=UTF-8
			
		q : query
		*/
		
		URL url = new URL("https://www.google.com/search?q=metamong&oq=metamong&aqs=chrome..69i57j0i512l3j0i30j0i10i30j0i30l2j0i5i10i30l2.1950j0j15&sourceid=chrome&ie=UTF-8");
		
		System.out.println("protocol : " + url.getProtocol());
		System.out.println("host, port : " + url.getAuthority());
		System.out.println("host : " + url.getHost());
		System.out.println("port : " + url.getPort());				//결과 : -1 => 보안으로 막아둔 상태
		System.out.println("경로 : " + url.getPath());
		System.out.println("질의(query) : " + url.getQuery());
		System.out.println("파일명 : " + url.getFile());
		System.out.println("참조 : " + url.getRef());
	}
}

package ex03.bufferedReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class MainEntry {
	public static void main(String[] args) throws Exception {	//예외처리 위임		누가 위임을 받는가? JVM(Java Virtual Machine)
//		InputStream is = System.in; //생성3
//		Reader reader = new InputStreamReader(is); //생성2 //추상 클래스 Reader >> 추상클래스이므로 자체적으로 생성 못하므로 상속받는? InputStreamReader를 가져옴
//		BufferedReader br = new BufferedReader(reader); //생성1
		
		//위 생성1~3코드는 이 코드 하나로 대체할 수 있다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine(); //예외발생		>> 1. try~catch		 2. 위임 throws Exception
		System.out.println(str);
	}
}

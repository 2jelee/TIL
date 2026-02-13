package ex06.io;

/*
 * Network를 이용한다면 openStream을 이용
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class UriCopy {
	public static void main(String[] args) throws MalformedURLException, IOException {	//예외처리 위임
		URL url = new URL("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"); //예외발생
		
		//읽기
		InputStream is = url.openStream();	// IOExeption import
		//쓰기
		OutputStream os = new FileOutputStream("google.jpg");
		
		byte[] buffer = new byte[1024 * 8];		//한꺼번에 읽어오겠다.  
		 
		while (true) {
			int inputData = is.read(buffer);		// buffer 크기만큼 data 읽어서 inputData에 담아라
			if(inputData == -1) break;
					//배열명 //시작점  //얼마만큼 읽어들일거야?
			os.write(buffer, 0, inputData);		//한꺼번에 쓰겠다.  //0부터 buffer 크기만큼 읽어라
		}  
		 
		is.close(); os.close(); 
		System.out.println("Web에서 해당 이미지 파일 copy success!");
	}
}

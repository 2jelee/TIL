package project1.ver08;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;

public class AutoSaverT extends Thread {
	HashSet<PhoneBookManager> hset = new HashSet<PhoneBookManager>();
	
	@Override
	public void run() { 
		while(true) {
			try {
				sleep(5000); //5초마다 자동저장
				try{ 
					ObjectOutputStream out = 
						new ObjectOutputStream(
							new FileOutputStream("src/project1/AutoSaveBook.txt"));
					for(PhoneBookManager p : hset) {
						out.writeObject(p); 
					}
					System.out.println("주소록이 텍스트로 자동저장되었습니다.");
				}
				catch (Exception e) {
					System.out.println("!! 정보를 파일저장 시 예외 발생");
					e.printStackTrace();
				}
			}
			catch (InterruptedException e) {
				System.out.println("!! 정보를 txt로 저장 시 오류 발생");
				e.printStackTrace();
			}
		}
	}
}

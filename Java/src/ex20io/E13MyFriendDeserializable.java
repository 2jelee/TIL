package ex20io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/*
연습문제] 직렬화된 파일 friend_info.obj을 복원하는 프로그램을 작성하시오.
	만약 3명의 친구가 저장되어있다면 복원후 3명의 정보를 그대로 출력하면
	된다. 
 */
public class E13MyFriendDeserializable {

	public static void main(String[] args) {
		try {
			//저장된 파일을 역직렬화(복원)하기 위한 입력스트림 생성
			ObjectInputStream in = 
				new ObjectInputStream(
					new FileInputStream("src/ex20io/friend_info.obj")
				);
			
			while(true) {			
				//Friend객체를 복원한다.
				Friend friend = (Friend)in.readObject();
				//더이상 복원할 내용이 없다면 루프를 탈출한다.
				if(friend==null) break;
				friend.showAllData();				
			}			
		}
		catch (Exception e) {
			//e.printStackTrace();
		}
		System.out.println("끄읕~~");
	}
}

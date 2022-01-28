package ex02.array;

public class MainEntry {
	public static void main(String[] args) {
		//1.
		char[] ch;			//이는 배열선언.	모든 프로그래밍 언어는 메모리에 할당이 되어야 사용이 가능함.
							//현재는 선언만 된 상태 O, 할당된 상태 X
		ch = new char[4];	//배열생성, 메모리에 할당된 상태
		
		/******************************************************************************/
		
		//2.
		char[] c = new char[4];		//배열선언+생성
		
		//배열초기화
		c[0] = 'J';
		c[1] = 'A';
		c[2] = 'V';
		c[3] = 'A';
		System.out.println(c[0]);
		System.out.println("------------");
		System.out.println(c[1]);
		System.out.println("------------");
		
		for(int i=0; i<c.length; i++) {				// 동일 : for(int i=0; i<4; i++) {		
			System.out.println(c[i]);
		}
		System.out.println("------------");
		
		/******************************************************************************/
		
		//3. 
		char[] cc = {'a', 'k', 'P', 'D', 'y', '7', 'e'}; 		// 초기화
		System.out.println(cc[1]);
		System.out.println("------------");
		
		for(int i=0;i<=4;i++) {						// 동일 : 배열의 길이를 구하는 필드 length 이용
			System.out.println(cc[i]);
		}
		System.out.println("------------");
		
		
		/******************************************************************************/
		
		
		String[] str = {"Re", "c", "1", "D", "you"};
		for(int i=0; i<str.length; i++ ) {
			System.out.println(str[i]);
		}
	}
}

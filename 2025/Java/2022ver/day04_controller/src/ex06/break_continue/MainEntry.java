package ex06.break_continue;

/*
 * break, continue
 */

public class MainEntry {
	public static void main(String[] args) {
		for(int i=1; i<11; i++) {
			if(i==7) {
				break; 	//i값이 7이라면 탈출		>> 즉, 7은 console에 안찍힌다.
			}
			System.out.println(i);
		}
		System.out.println("main END \n");
		
		
		/****************************************/
		
						   //▼여기					//for (초기값; 조건(식); 증감식) {
		for(int i=1; i<11; i++) {
			if(i==7) {
				continue;							//while이나 do~while은 조건식으로 가고 | for는 해당 예제에서 i++인 for문 증감식으로 간다.
			}
			System.out.println(i);
		}
		System.out.println("main END \n");			//결과 : 7빼고 10까지 출력됨.
		
		
		/***************************************/
		
		
		for(int i=1; i<101; i++) {
			if(i % 2 != 0) {						// >> 즉, i를 2로 나누었을때 0이 아니라면 >> 홀수라면
				continue;
			}
			System.out.print(i+"\t");				//결과 : 2	 4	6	8	10	12	14	16	18	20, ..., 100	 와 같이 짝수만 출력됨
		}
		
	}
}

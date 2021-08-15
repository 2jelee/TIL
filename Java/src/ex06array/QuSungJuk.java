package ex06array;

import java.util.Scanner;

/*
1] 학생수를 사용자로부터 입력받는다.
	-Scanner클래스 사용
2] 입력받은 학생수만큼 국영수 점수를 저장할 수 있는 int형 배열을 선언한다.
3] 다시 학생수만큼 각 학생의 국영수 점수를 입력받아 2]에서 생성한 배열에 저장한다.
	-Scanner클래스 사용
4] 각 학생의 국영수 점수 및 총점 그리고 평균을 출력하여라. 
5] 이 문제는 2차원 배열을 활용하는 문제이다.

 */
public class QuSungJuk {

	//과목수를 저장하기위한 상수 선언
	public static final int SUBJECTS=3;	 
	
	public static void main(String[] args) {
		
		//1] 학생수를 사용자로부터 입력받자
		//-Scanner클래스 사용
		Scanner sc = new Scanner(System.in);
		System.out.println("학생수를 입력하세요?");
		int numberOfStudent = sc.nextInt();
		System.out.println("학생수:"+numberOfStudent);

		//2] 입력받은 학생 수만큼 국영수 점수를 저장할수 있는
		//   int형 배열을 선언하고  메모리를 할당해라
		//행의 수:학생 수
		//열의 수:과목의 수
		int[][] jumsues = new int[numberOfStudent][SUBJECTS];
		
		//과목 타이틀]
		String[] titles={"국어","영어","수학"};
		
		//3] 다시 학생 수만큼 각 학생의 국영수 점수를 입력받아
	    //   2]에서 생성한 배열에 저장해라.* 
		//   -Scanner클래스 사용
		for(int i=0; i<jumsues.length ; i++){
			System.out.printf("[%d번째 학생의 점수 입력]%n",i+1);
			//i번째 학생의 국영수 점수 입력 받기
			for(int k=0; k < SUBJECTS;k++){
				System.out.println(titles[k]+"점수 입력?");
				jumsues[i][k]=sc.nextInt();
			}
		}
		
		//4] 각 학생의 국영수 점수 및 총점 그리고 평균을 출력하여라. 
		System.out.println("==========================");
		System.out.printf("%-3s%-4s%-4s%-4s%-4s%s%n","NO","KOR","ENG","MAT","TOT","AVG");
		System.out.println("==========================");
		
		//점수 배열의 세로크기만큼 반복(학생수)
		for(int i=0 ; i<jumsues.length ; i++) {
			int total = 0;
			
			//NO(학생번호) 출력
			System.out.printf("%-3d", i+1);
			
			//과목수 만큼 반복
			for(int j=0 ; j<SUBJECTS ; j++) {
				//각 과목의 합을 구해서 total에 누적함. 즉 총점을 구함.
				total += jumsues[i][j];
				System.out.printf("%-4d", jumsues[i][j]);
			}
			//총점과 평균을 출력함.
			System.out.printf("%-4d %.2f %n", 
					total, (double)total/SUBJECTS);
		}
		System.out.println("==========================");
		
	}

}

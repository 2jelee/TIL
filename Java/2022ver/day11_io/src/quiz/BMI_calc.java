package quiz;

import java.util.Scanner;
import java.util.TreeMap;

/*
- 체질량지수(BMI)-비만도 측정 프로그램 작성하기
    - collection, file, io 이용
    - 추가 / 삭제 / 출력 / 파일 저장 / 종료 처리하기
    - 몸무게, 키 입력 받아서 BMI 계산하기
    - BMI = 몸무게 / ((키/100.0) * (키/100.0)) ;
    - 남 : (신장cm - 100) * 0.9
    - 여 : (신장cm - 100) * 0.85
    - 판정
        - 18.5미만 : 저체중(체중부족)
        - 18.5~22.9 : 표준
        - 23.0 ~ 24.9 : 과체중
        - 25.0 이상 : 비만
 */
public class BMI_calc extends BMI_Main { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeMap tm = new TreeMap(); 
		System.out.print("키를 입력해주세요 : ");
		tm.put("tall", sc.nextInt());
		System.out.print("몸무게를 입력해주세요 : ");
		tm.put("weight", sc.nextInt());
		
		System.out.println(tm);
	}
	
	public BMI_calc() {

		System.out.println(tm);
	}
	
}

package etc_FEB.book;

/*
 * [신체검사 데이터의 일람표, 평균 키, 시력분포 보여주기] _클래스의 배열
 * 
 * 클래스에 대해 상세히 정리하면 양이 방대하므로,
 * 최소한으로 알아야할 사항을 정리
 * 
 * 클래스 본체와 멤버
 * 1. '클래스 본체'에서는 다음과 같은 내용을 '선언'할 수 있다.
 * 	 - 멤버(필드/메서드/중첩(nested) 클래스/중첩(nested) 인터페이스)
 * 	 - 클래스 초기화 / 인스턴스 초기화
 *   - 생성자
 * 2. 필드/메서드/생성자를 선언할 때 public/proteced/private을 지정할 수 있다.
 * 3. 메서드/생성자는 '다중으로 정의(오버로드)'할 수 있다.
 * 4. final으로 선언한 필드는 '한 번만 값을 대입'할 수 있다.
 * 5. 생성자는 새로 생성한 인스턴스의 초기화를 위해 사용된다.
 * 
실행 결과 : 
			--신체검사 리스트--
			이 름     키    시력
			----------------------
			박현규     162  0.3
			함진아     173  0.7
			최윤미     175  2.0
			홍연이     171  1.5
			이수진     168  0.4
			김영준     174  1.2
			박용규     169  0.8
			
			평균키 : 170.3cm
			
			시력 분포
			0.0 ~ : 0명
			0.1 ~ : 0명
			0.2 ~ : 0명
			0.3 ~ : 1명
			0.4 ~ : 1명
			0.5 ~ : 0명
			0.6 ~ : 0명
			0.7 ~ : 1명
			0.8 ~ : 1명
			0.9 ~ : 0명
			1.0 ~ : 0명
			1.1 ~ : 0명
			1.2 ~ : 1명
			1.3 ~ : 0명
			1.4 ~ : 0명
			1.5 ~ : 1명
			1.6 ~ : 0명
			1.7 ~ : 0명
			1.8 ~ : 0명
			1.9 ~ : 0명
			2.0 ~ : 1명
 */

import java.util.Scanner;

class page91_PhysicalExamination {
	static final int VWAX = 21; // 시력분포(0.0에서 0.1 단위로 21개) 
	
	static class PhyscData{
		String name;
		int height;
		double vision; //시력
		
		//생성자
		PhyscData(String name, int height, double vision){
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
	}
	
	//키의 평균값
	static double avgHeight(PhyscData[] data) {
		double sum = 0;
		
		for(int i=0; i<data.length; i++) {
			sum += data[i].height;
		}
		return sum / data.length;
	}
	
	//시력분포 구하기
	static void distVision(PhyscData[] data, int[] dist) {
		int i = 0;
		dist[i] = 0;
		for(i=0; i<data.length; i++) {
			if(data[i].vision >= 0.0 && data[i].vision <= VWAX / 10.0) {
				dist[(int)(data[i].vision * 10)]++;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PhyscData[] x = {
			new PhyscData("박현규", 162, 0.3),
			new PhyscData("함진아", 173, 0.7),
			new PhyscData("최윤미", 175, 2.0),
			new PhyscData("홍연이", 171, 1.5),
			new PhyscData("이수진", 168, 0.4),
			new PhyscData("김영준", 174, 1.2),
			new PhyscData("박용규", 169, 0.8)
		};
		int[] vdist = new int[VWAX]; //시력 분포
		
		System.out.println("--신체검사 리스트--");
		System.out.println("이 름     키    시력");
		System.out.println("----------------------");
		for(int i=0; i<x.length; i++) {
			System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
		}
		System.out.printf("\n평균키 : %5.1fcm\n", avgHeight(x));
		
		distVision(x, vdist); //시력분포를 구함
		
		System.out.println("\n시력 분포");
		for(int i=0; i<VWAX; i++) {
			System.out.printf("%3.1f ~ :%2d명\n", i/10.0, vdist[i]);
		}
	}
}
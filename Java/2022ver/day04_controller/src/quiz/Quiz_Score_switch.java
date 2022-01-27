package quiz;

/*
[문제 3.] 전산, 영어, 국어 점수 입력 받아서 평균 60점 이상이고
각 과목 과락 40점 이하이면 과목 불합격 처리
*/

import java.util.Scanner;


public class Quiz_Score_switch {
	
//	public static void main(String[] args) { 

//		//학점(평점) : A~F 학점 - switch문 이용
//		System.out.println("전산, 영어, 국어 순서대로 점수를 입력하세요.");
//		int com = new Scanner(System.in).nextInt();
//		int eng = new Scanner(System.in).nextInt();
//		int kor = new Scanner(System.in).nextInt();
//		int tot = com+eng+kor;
//		double avg = tot/3.0;
//		
//		
//		String grade = null;
//		
//		switch ((int)avg) {
//		case 100:
//		case 90:	grade = "A"; break;
//		case 80:	grade = "B"; break;
//		case 70:	grade = "C"; break;
//		case 60:	grade = "D"; break;
//		default:	grade = "F"; break; 
//		}
//		System.out.println("점 입니다.");
//	}
	
	/*************************************************************************/
	
	/*
	public static void main(String[] args) { 

		//학점(평점) : A~F 학점 - switch문 이용
		System.out.println("Input your score(k,e,c) : ");
		Scanner sc = new Scanner(System.in);
	
		int tot = (sc.nextInt()+sc.nextInt()+sc.nextInt());
		double avg = tot/3.0;
		
		char grade;
		
		switch ((int)avg) {		//switch(total/30){
			case 100:							//이와 같은 경우 81, 81, 81 입력 시 F학점 나옴 >> Why? 구간이 없으므로
			case 90:	grade = 'A'; break;
			case 80:	grade = 'B'; break;
			case 70:	grade = 'C'; break;
			case 60:	grade = 'D'; break;
			default:	grade = 'F'; break; 
		} //end of switch
		System.out.println("\n\n"+tot+" ==> " + grade+"학점");
	}
	*/

	/*************************************************************************/
	
	public static void main(String[] args) { 
		System.out.print("이름을 입력해주세요 : ");
		String name = new Scanner(System.in).next();
		
		System.out.println("성적을 입력해주세요.(순서 => 국어, 영어, 전산) : ");
		int kor = new Scanner(System.in).nextInt();
		int eng = new Scanner(System.in).nextInt();
		int com = new Scanner(System.in).nextInt();
//		Scanner sc = new Scanner(System.in);
//		int tot = (sc.nextInt()+sc.nextInt()+sc.nextInt());
		int tot = (kor+eng+com);
		double avg = tot/3;
		char grade; 
		
		switch ((int)avg / 10) {		// 앞자리를 한 자릿수로 만들어서 ( /10 )	 
			case 10:							
			case 9:	grade = 'A'; break;
			case 8:	grade = 'B'; break;
			case 7:	grade = 'C'; break;
			case 6:	grade = 'D'; break;
			default:	grade = 'F'; break; 
		} //end of switch
		System.out.println("\n\n*** "+ name +" ==> " +"님의 성적표 ***");
		System.out.println("국어 : " +kor+" 영어 : " + eng + " 전산 : " + com);
		System.out.printf("총점 : %d 평균 : %.2f  %c학점 \n", tot, avg, grade);
	}
}

//문제 : 28일.. ~

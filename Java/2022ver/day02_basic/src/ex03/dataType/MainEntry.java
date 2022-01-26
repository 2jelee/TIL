package ex03.dataType;

//22.01.26
public class MainEntry {
	public static void main(String[] args) {
		int su = 10;
		
		System.out.printf("10진수 : %d \n", su);
		System.out.printf("8진수 : %o \n", su);
		System.out.printf("16진수 : %x %X \n", su, su);
		
		//변환 가능
		System.out.printf("\n\n %d %x %o %X \n", 10, 10, 10, 10);
		
		// 0숫자 -> 8진수, 0x -> 16진수
		System.out.printf("%d \n", 012);	//12에 앞에 0을 붙임
		System.out.printf("%d \n", 0xA);
		
		double f = 12.34;
		System.out.println(f);
//		float ff1 = 12.34;		 //error : 대입연산자(=)는 우에서 좌로 간다. (원래는 위에서 아래로, 좌->우)	이 경우, 12.34를 double로 인식
		float ff = 12.34f;		 //따라서 뒤에 접미사 붙여줘야 한다.
		System.out.println(ff);
	}
}

/*
package ex03.dataType;

public class MainEntry {
	public static void main(String[] args) {
		short sh = 32767;		// -32,768 ~ 32,767
		int num = 32769; 		// -21억 ~ 21억
		
		System.out.println(sh + ":" + num);
		
		num = -32769;
//		sh = num;		 // error
		num = sh;		 // 묵시적 형변환
		sh = (short)num; //명시적 형변환 | [큰 -> 작] 데이터 손실 발생 | [작->큰] 자동형변환
		System.out.println(sh + " : " + num);
	}
}
*/

/*
 * package ex03.dataType;
 * 
 * public class MainEntry { public static void main(String[] args) { String str
 * = "A"; //문자열, "", 2byte, A\0 char ch = 'A'; //문자, '', 1byte → (국제표준)2byte
 * char ch2 = 67; char ch3 = 'b'; //ASCII 98 int su = 20; String name = "happy";
 * double dd = 12.34, ff = 3.45;
 * 
 * System.out.println(ch); //A System.out.println(str); //A
 * System.out.println((int)ch); //ASCII 65 System.out.println(ch2 + ch3);
 * System.out.println("name = " + name); System.out.println("실수형 데이터 : " + dd);
 * System.out.printf("%f %f \n", dd, ff); // \n : 개행
 * System.out.println("--------------------------");
 * 
 * for(int i=65; i<=90; i++) { // System.out.print(i + " ");
 * System.out.print((char)i + " "); } //end for
 * System.out.println("\n\n============================="); for(int i='a';
 * i<='z'; i++) { System.out.println((char)i+" "); } //end for
 * 
 * System.out.println("\n\n boolean type"); boolean flag = true; // int b =
 * flag; //error >> 무조건 true/false이므로. 형변환 X System.out.println(flag); } }
 */

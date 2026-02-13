package ex04.Input;

public class MainInput {
	public static void main(String[] args) { 		//[] 배열 몇개든 들어올 수 있다.	>> 배열 : 0번부터 시작
		System.out.println("string, int = ");
		
		String str = args[0]; 
//		String strSu = args[1];				//error
//		int su = Integer.parseInt(strSu); 	//형변환
		int su = Integer.parseInt(args[1]);
		
		System.out.println(str);
		System.out.println(su + 33);
		
	}
}

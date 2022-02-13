package ex02.io;

public class MainEntry {
	public static void main(String[] args) throws Exception {
		int su1=0, su2 = 0;
		System.out.println("데이터 입력 끝은 Ctrl+z를 누르세요");
		
		//throws Exception처리함으로써 error 사라짐
		while ((su1=System.in.read())!= -1){	//read는 int형이므로 더이상 읽어들일게 없을 경우 -1로
			System.out.println(su1 + "\t");
		}
		
		su2=System.in.read();
		System.out.println(su2+1000);
	}
}

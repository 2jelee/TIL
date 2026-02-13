package ex02.io;

public class MainEntry_1 {
	public static void main(String[] args) {
		System.out.println("input = ");
		
		try {
			int su;
			while((su=System.in.read())!=-1) {
				if(su==10|| su==13|| su==32)	// space bar || tab || enter
					continue;
				if(su==113||su==81) 			// 'q' || 'Q'
					break;
				
				char ch = (char)su;
				System.out.println(ch);
			}
		} catch (Exception e) { 
			e.printStackTrace(); //<< 되도록이면 해당 코드칸을 비우지 말자
		}
	}
}

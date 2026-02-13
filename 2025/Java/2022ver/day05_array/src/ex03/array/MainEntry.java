package ex03.array;

//code rere

public class MainEntry {
	public static void main(String[] args) {
		//3차원배열 - 선언 및 생성
		int[][][] a = new int[2][2][3]; 
		
		//2. 
		int[][][] a2 = new int[][][] {{{1,2,3},{4,5,6}},{{1,2,3},{4,5,6}}};
		//3.
		int[][][] a3 = {{{1,2,3},{4,5,6}},{{1,2,3},{4,5,6}}};
		
		System.out.println("면 길이 : "+ a3.length);
		System.out.println("행 길이 : "+ a3[0].length);
		System.out.println("열 길이 : "+ a3[0][0].length);
		System.out.println("열 길이 : "+ a3[1][0].length);
		
		for(int i=0; i < a3.length; i++) { //면의길이
			
			for (int j=0; j < a3[i].length; j++) { //행의크기
				
				for(int k=0; k < a3[i][j].length;k++) { //열의길이
					System.out.print(a3[i][j][k] + "\t");
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println();
	}
}

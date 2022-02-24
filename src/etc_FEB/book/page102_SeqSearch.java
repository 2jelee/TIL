package etc_FEB.book;

/*
 * [선형 검색]  
 * 
실행 결과 :  
 */

import java.util.Scanner;

class page102_SeqSearch {
	static int seqSearch(int[] arr, int n, int key) {
		int i = 0;
		
		while(true) {
			if(i==n) return -1;
			if(arr[i]==key) return i;
			i++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num=sc.nextInt();
		int[] x = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("x["+i+"] : ");
			x[i] = sc.nextInt();
		}
		int ky = sc.nextInt();
		int idx = seqSearch(x, num, ky);
		
		if(idx==-1) System.out.println("그 값의 요소가 없다.");
		else System.out.println(ky+"은(는) x["+idx+"]에 존재함.");
	}
}
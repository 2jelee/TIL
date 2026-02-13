package etc_MAR.book;

import java.util.Scanner;

//선형 검색(보초법)

class page105_SeqSearchSen {
	static int seqSearchSen(int[] a, int n, int key) {
		int i=0;
		a[n]=key; //보초 추가
		while(true) {
			if(a[i]==key) { //검색 성공
				break;
			}
			i++;
		}
		return i == n ? -1 : i;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] x = new int[num+1]; //요소수 num+1
		
		for (int i = 0; i < num; i++) {
			x[i] = sc.nextInt();
		}
		
		int ky = sc.nextInt();
		int idx = seqSearchSen(x, num, ky); 
	}
}

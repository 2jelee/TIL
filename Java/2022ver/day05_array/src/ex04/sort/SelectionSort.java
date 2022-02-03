package ex04.sort;

public class SelectionSort {
	public static void main(String[] args) {
		int[] a = {7, 3, 5, 2, 8}; //1차원배열
		int temp; //빈값
		
		//배열이므로 for문으로 출력
		System.out.println("=== sort 전 출력 ===");
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+"\t");
		}

		//sort
		for(int i=0; i<a.length; i++) {
			for(int j = i+1; j < a.length; j++) {
				//교환 발생
				if(a[i]>a[j]) {
					temp = a[i];	//빈 변수에 담아줌
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		//배열이므로 for문으로 출력
		System.out.println("=== sort 후 출력 ===");
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+"\t");
		}
	}
}

package ex04.sort;

public class BubbleSort {
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
			for(int j=0; j<a.length-i-1; j++) {	//개별적으로 나오므로 회전하는데 계산에서 빼줌?
				if(a[j] < a[j+1]) {	//내림차순 (부등호 방향만 바꾸면 오름차순)
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
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

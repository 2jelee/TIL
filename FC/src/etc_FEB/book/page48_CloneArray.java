package etc_FEB.book;

/*
[배열의 복제(Clone)]
배열을 복제하고 복제한 배열에 대한 참조를 생성.

실행 결과 :
a = 1 2 3 4 5
b = 1 2 3 0 5 
 */

class page48_CloneArray {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		int[] b = a.clone();
		
//		System.out.println(b[i]);
		b[3] = 0;
		
		System.out.print("a =");
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		
		System.out.print("\nb =");
		for (int i = 0; i < b.length; i++) {
			System.out.print(" "+b[i]);
		}
	}
}

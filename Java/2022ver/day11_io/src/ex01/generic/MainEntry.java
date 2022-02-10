package ex01.generic;

public class MainEntry {
	public static void main(String[] args) {
		GenericEx<String> t1 = new GenericEx<String>();
		String[] str = {"abc", "kbs", "2jelee"};
		t1.set(str);
		t1.print();
		System.out.println("-----------------------------------");

		//wrapper class >> Integer
		GenericEx<Integer> t2 = new GenericEx<Integer>();
//		int[] num = {1,2,3,4,5,6,7};		//error >> wrapper로 들어가야 한다.
		Integer[] num = {1,2,3,4,5,6,7};
		t2.set(num);
		t2.print();
		System.out.println("-----------------------------------");

		GenericEx<Double> t3 = new GenericEx<Double>();
//		int[] num = {1,2,3,4,5,6,7};		//error >> wrapper로 들어가야 한다.
		Double[] dou = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
		t3.set(dou);
		t3.print();
	}
}

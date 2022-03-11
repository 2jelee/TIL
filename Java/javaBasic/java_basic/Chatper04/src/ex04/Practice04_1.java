package ex04;

/*
 * 1 + (-2) + 3 + (-4) + ... 와 같은 식으로 계속 더할 때 몇까지 더해야 총합이 100이상이 되는가?
 */

public class Practice04_1 {
	public static void main(String[] args) { 
		int buho = 1;
		int sum = 0;
		int total = 0;

		while (total>=100) {
			for (int i = 1; ; i++) {
				
				buho = -i;
				sum += i*buho;
				
			}
		}
		System.out.println(sum);
	}
}

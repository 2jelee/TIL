package quiz;

public class quiz_220128 {
	/*
	[과제1] 1+(1+2)+(1+2+3)+...+(1+2+3+...+5) = ?			>> 35
	*/
	/*
	public static void main(String[] args) { 
		int a,b,c;
		a=0; b=0; c=0;
		
		while (a<=4) {
			a++;
			b += a;
			c += b;
		}
		System.out.println(c); 
	}
	*/ 

	/********************************************************/
	
	/*
	[과제2] (-1) + 2 +(-3) + 4 + ... +(-9) + 10 = ?			>> 5
	=> 홀수는 -기호 붙이기
	 */
	public static void main(String[] args) {
		
		/*
		int a, b;
		
		// -1 = 1-2
		// n = -n+(n+1)		>> n = m+1
		
		
		for (int i=0; i<=10; i++) {
			System.out.println("i="+i);System.out.println();
			for(int j=0; j+i<=10; j++) {
				System.out.println("j=" + j);
			}
		}
		System.out.println();
		*/
		int a,b; 	
		
		while(a<=10) {
	        if(a%2 == 0) {
	           result += a;
	        }
	        else {
	           result += -a;
	        }
	        a++;
	    }
	    System.out.println(result);
		
		
		

	/********************************************************/
		
	/*
	[과제3] 1/2 + 2/3 + 4/5 + ... + 9/10 = ? >> 7.07
	 */
//	public static void main(String[] args) {
	    /*
	    a = 2;
	    double re =0;
	      
	    for(int i =1; i<=9; i++) {
	       re += (i/(double)a);
	       a++;
	    }
	    System.out.println(re);
	    */
	}
}


package ex01.string;

public interface StringMain {
	public static void main(String[] args) {
		int x=3, y=5;
		System.out.println("x = "+x+"\ty="+y);
		System.out.println("x = "+x+"\ty="+y);
		x=y;
		System.out.println("x = "+x+"\ty="+y);
		
		
		//String은 불변
		//한 번 셋팅 후 한번 바꾸면 상관없으나, 수시로 바꿔야한다면 String 사용 지양
		//한 번이라도 써져있으면 메모리에 남아있어, 같은 주소를 호출하게 된다.
		String s1 = "korea";
		String s2 = "happy";
		System.out.println("s1 = "+s1+"\ts2 "+s2);
		System.out.println("hashcode : "+ s1.hashCode()+"\t /"+ s2.hashCode()); //	102236330	 /99047136
		s1 = s2;
		System.out.println("s1 =" +s1 + "\ts2 = "+s2);
		System.out.println("hashcode : "+s1.hashCode()+"\t /"+s2.hashCode());	//	99047136	 /99047136
		s1 = "2jelee";
		System.out.println("s1 =" +s1 + "\ts2 = "+s2);
		System.out.println("hashcode : "+s1.hashCode()+"\t /"+s2.hashCode());	//	1532466687	 /99047136
		s2 = "KOSA";
		System.out.println("s1 =" +s1 + "\ts2 = "+s2);
		System.out.println("hashcode : "+s1.hashCode()+"\t /"+s2.hashCode());	//	1532466687	 /2312882

		
		System.out.println("==========================================");
		
		s2 = "happy";
		s1 = s2;
		System.out.println("s1 =" +s1 + "\ts2 = "+s2);
		System.out.println("hashcode : "+s1.hashCode()+"\t /"+s2.hashCode());	//	99047136	 /99047136 
		//과거에 한 번이라도 생성했다면 메모리에 남아있어, 같은 주소를 가지게 된다. => 문제발생 소지 有 , 메모리 낭비 발생
		//다시 글자가 생기는 것이 X. 있던 것 반환하는 것!
		
		s2 = "대한민국";
	    String s3 = "happy";
	    System.out.println("s3.hashcode() : "+s3.hashCode());
	    System.out.println(s3);
	}
}

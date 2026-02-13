package ex06;

/*
 * Student 클래스에 생성자와 info()를 추가하시오.
 * 
 * 실행결과 : 홍길동, 1, 1, 100, 60, 76, 236, 78.7
 */

class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	//생성자 생성
	Student(String name, int ban, int no, int kor, int eng, int math) {
		super();
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	//info() 메서드 생성
	public String info() {
		return name + ", " + ban + ", " + no + ", " + kor + ", " + eng + ", " + math
				+ ", " + (kor+eng+math)+ ", " + ((int)((kor+eng+math)/3f*10+0.5f)/10f);
	}
	
}

class Practice02 {
	public static void main(String[] args) {
		Student s = new Student("홍길동", 1, 1, 100, 60, 76);
		
		String str = s.info();
		System.out.println(str);
	}

}

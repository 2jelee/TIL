package ex06;

/*
 * 두 개의 메서드 getTotal()과 getAvarage()를 추가하시오.
 */

class Stud {
	String name;
	int ban, no, kor, eng, math;
//	int total;
//	double avg;
	 
	//기본 생성자
	Stud() { };
	
	//생성자 생성
	Stud(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	//메서드 생성
	int getTotal() { 
		return kor+eng+math;
	}

	float getAvg() {
		return (int)(getTotal()/3f*10+0.5f)/10f;
	}
	
	public String info() {
		return name + ", " + ban + ", " + no + ", " + kor + ", " + eng + ", " + math
				+ ", " + getTotal() + ", " + getAvg();
	}
}

class Practice03 {
	public static void main(String[] args) { 
		Stud s = new Stud();
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		
		System.out.println("이름 : " + s.name);
		System.out.println("총점 : " + s.getTotal());
		System.out.println("평균 : " + s.getAvg());
	}
}

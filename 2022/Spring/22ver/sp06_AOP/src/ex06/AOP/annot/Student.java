package ex06.AOP.annot;

public class Student {
	private String name;
	private int age, gradeNum, classNum;
	
	// set method가 있다 = DI하겠다.  | 외부주입 방법 1. 생성자		2. setter  
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGradeNum() {
		return gradeNum;
	}
	public void setGradeNum(int gradeNum) {
		this.gradeNum = gradeNum;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	
	public void getStudentInfo() {
		System.out.println("이름 : " + getName());
		System.out.println("나이 : " + getAge());
		System.out.println("학년 : " + getGradeNum());
		System.out.println("반 : " + getClassNum());
	}
}

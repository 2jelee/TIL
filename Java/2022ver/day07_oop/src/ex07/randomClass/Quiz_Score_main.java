package ex07.randomClass;

import java.util.Scanner;

public class Quiz_Score_main {
	protected String name;
	public Quiz_Score_main() {
		
	} 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		System.out.print("성적표를 출력할 이름은? ");
		Quiz_Score_main main = new Quiz_Score_main();
		main.setName(sc.next());
		Quiz_Score_subject subj = new Quiz_Score_subject();
		subj.point();  
		Quiz_Score_grade grade = new Quiz_Score_grade();
		grade.grade();
	}
}

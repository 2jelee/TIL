package ex07.randomClass;

import java.util.Scanner;

public class Quiz_Score_grade extends Quiz_Score_subject{  
	private char grade;
	public Quiz_Score_grade() { 
	} 
 	
	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public char grade() {
		char grade;
		switch ((int)  avg / 10) {
	        case 10:
	        case 9: grade = 'A'; break;
	        case 8:grade = 'B'; break;
	        case 7:grade = 'C'; break;
	        case 6: grade = 'D'; break;
	        default:grade = 'F';
		}
		return grade;
	}

	public void show() {
		Quiz_Score_subject subj = new Quiz_Score_subject();
		subj.getAvg();
		System.out.println("getAvg"+getAvg());
	}
}

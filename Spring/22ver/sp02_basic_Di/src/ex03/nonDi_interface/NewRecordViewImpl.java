package ex03.nonDi_interface;

import java.util.Scanner;

// DTO
public class NewRecordViewImpl implements iRecordView {

	// instance
	private NewRecordImpl record;
	
	// setter로 주입
	public void setRecord(NewRecordImpl record) {
		this.record = record;
	}
	
	
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 : ");
		record.setKor(sc.nextInt());
		
		System.out.println("영어 : ");
		record.setEng(sc.nextInt());
		
		System.out.println("수학 : ");
		record.setMath(sc.nextInt());
		
	}

	public NewRecordImpl getRecord() {
		return record;
	}


	@Override
	public void print() {
		System.out.println("\n\nkor : " + record.getKor());
		System.out.println("영어 : " + record.getEng());
		System.out.println("수학 : " + record.getMath());
		
		System.out.println("total : " + record.total()+ "\tavg : " + record.avg());
		
	}

}

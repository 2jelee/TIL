package ex01.nonDi;

public class NewRecordView {

	private NewRecord record;
	
	// 필요한 객체를 "생성자"를 통해서 주입받아서 사용 
	// 두 객체의 LifeCycle이 동일 
	public NewRecordView(int kor, int eng, int math, int com) {
		record = new NewRecord(kor, eng, math, com);
	}
	
	public void print() {
		System.out.println("국어: "+record.getKor());
		System.out.println("합계: "+record.total()+" / 평균: "+record.avg());
	}
	
}

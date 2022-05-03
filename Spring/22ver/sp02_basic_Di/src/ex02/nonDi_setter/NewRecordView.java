package ex02.nonDi_setter;

public class NewRecordView {

	private NewRecord record;
	
	// 필요한 객체를 "setter method"를 통해서 주입받아서 사용
	// 두 객체의 LifeCycle이 동일 X -> 객체의 생성이 서로 독립적, 필요 시 객체에 주입 
	public void setRecord(NewRecord record) {
		this.record = record;
	}
	
	public void print() {
		System.out.println("[set] 국어: "+record.getKor());
		System.out.println("합계: "+record.total()+" / 평균: "+record.avg());
	}
	
}

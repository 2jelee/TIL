package ex03.nonDi_interface;

public class MainEntry {
	public static void main(String[] args) {
//		iRecord record = NewRecordImpl(); // 아래와 같다 
		NewRecordImpl record = new NewRecordImpl();
		
//		iRecordView view = new NewRecordViewImpl();
		NewRecordViewImpl view = new NewRecordViewImpl();
		
		// 조립 
		view.setRecord(record);
		view.input();
		view.print();
	}
}

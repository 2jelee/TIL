package etc_MAR.book;

class Id{
	private static int counter = 0;
	private int id;
	
	public Id() {
		id = ++counter;
	}
	public int getId() {
		return id;
	}
	public static int getCounter() {
		return counter;
	}
}

public class page121_IdTester {
	public static void main(String[] args) {
		Id a = new Id();
		Id b = new Id();
		
		System.out.println("부여한 ID 갯수 : " + Id.getCounter());
	}
}

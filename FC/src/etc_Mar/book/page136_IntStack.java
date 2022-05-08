package etc_MAR.book;

public class page136_IntStack {
	private int max; 	//스택 용량
	private int ptr; 	//스택 포인터
	private int[] stk;  //스택 본체
	
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() { }
	}
	
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() { }
	}
	
	//생성자
	public page136_IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];
		} catch (OutOfMemoryError e) { //생성할 수 없음
			max = 0;
		}
	}
	
	public int push(int x) throws OverflowIntStackException {
		if(ptr >= max) { 	//스택이 가득 참
			throw new OverflowIntStackException();
		}
		return stk[ptr++] = x;
	}
}
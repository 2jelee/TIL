package ex01.thread;

public class UserThread {
	public static void main(String[] args) {
		String name;
		
		public UserThread(String name) {
			this.name = name;
		}
		
		public void run() {
			System.out.println(name);
			
			for (int i = 1; i <= 10; i++) {
				if(i==7) {
					try {
						sleep(500);	//0.5초 동안, 1/1000 = 1초
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}// End of for
				
				System.out.println(i);
			}
		}
	}
}

package ex06.break_continue;

public class MultiBreak {
	public static void main(String[] args) {
		
		/*
		int x=3;						// >> stack영역에 3, 5순으로 쌓이고 statck영역에 있는 것들은 {}안에서만 생존가능
		{
			System.out.println(x);
			
			int y =5;
			System.out.println(y);
		}
		System.out.println(y);			// >> 그러므로 해당 출력문의 y는 {} 밖에 있어서 선언되지 않았다고 나온다.
		*/
		
		boolean flag = true;
		
		first : {
			second : {
				third : {
					int k = 100;
					System.out.println("Before the break");
					
					if(flag) break second;		//break가 걸리면 해당 블록의 가장 가까운 바깥쪽으로 나가게 되는데(디폴트임) 
												//break뒤에 지정해주면 특정위치(지정)으로 빠져나간다!
					System.out.println("This won't execute");		//이는 실행되지 않음.
				}//end of third
				System.out.println("화이팅!");
			}//end of second
			System.out.println("This is after second block");
		}//end of first
	}
}


/*
 * 식별자1 : {
 * 		식별자2 : {
 * 		
 * 				break 식별자;			>>식별자 1로 빠져나간다????????????
 * 		}
 * }
 * 
 */

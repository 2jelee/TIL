package ex18lambda;

import java.util.function.Consumer;

public class Ex06Define3Consumer {

	/*
	Consuber<T>
		: 소비자라는 뜻을 가지고 있어, 매개변수는 있으나
		반환값은 없는 accept() 메소드를 가지고 있다.
		즉, 매개변수를 소비하는 형태라 보면 되고
		리턴값이 없어서 단순한 출력결과만을 보여준다.
	 */
	public static void main(String[] args) {
		/*
		interface Consumer<T>{
			void accept(T t);
		}
		 */
		Consumer<String> c1 = (String s) -> {
			System.out.println(s +" 는(은) 가수입니다.");
		};
		c1.accept("케이윌");
		
		Consumer<String> c2 = t -> {
			System.out.println(t + " 는(은) 과일입니다.");
		};
		c2.accept("Strawberry");
	}

}

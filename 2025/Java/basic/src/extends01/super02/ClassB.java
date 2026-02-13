package extends01.super02;

public class ClassB extends ClassA {
    public ClassB(int a) {
        super(); // 기본 생성자 생략 가능 => 매개변수 없는 기본 생성자의 경우 생략하면 java가 자동으로 만들어줌.
        System.out.println("classB 생성자 a = " + a);
    }

//    public ClassB(int a) {
//        this(a, 0); // 기본 생성자 생략 가능 => 매개변수 없는 기본 생성자의 경우 생략하면 java가 자동으로 만들어줌.
//        System.out.println("classB 생성자 a = " + a);
//    }

//    public ClassB() {
//        super();
//        System.out.println("classB 생성자 ");
//    }

    // 위 생성자말고 아래 생성자가 호출됨. super(10,20); 로 호출했음.
    public ClassB(int a, int b){
        super(); // 이 또한, 기본생성자 생략 가능
        System.out.println("ClassB 생성자 a = " + a + ", b = " + b);
    }

}

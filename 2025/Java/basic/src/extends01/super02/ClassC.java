package extends01.super02;

public class ClassC extends ClassB {
    public ClassC() {
        super(10); // super(); // super(); 불가능 -> ClassB에서 기본생성자가 아니므로
//        super(10, 20); // super(); // super(); 불가능 -> ClassB에서 기본생성자가 아니므로
        // 즉, 부모가 기본 생성자가 없으면 내가 super()를 직접 정/호출해야 한다.
        // 기본 생성자(super();)인 경우에만 생략 가능
        System.out.println("ClassC 생성자");
        /**
         * [정리]
         * 상속 관계의 생성자 호출은 결과적으로 부모에서 자식 순서로 실행된다.
         * 따라서 부모의 데이터를 먼저 초기화하고 그 다음에 자식의 데이터를 초기화한다.
         * 상속 관계에서 자식 클래스의 생성자 첫줄에 반드시 `super(...)` 를 호출해야 한다.
         * 단, 기본 생성자(`super()` )인 경우 생략할 수 있다
         */
    }
}

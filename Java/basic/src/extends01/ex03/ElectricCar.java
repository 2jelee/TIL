package extends01.ex03;

/**
 * [지금까지 설명한 상속과 메모리 구조는 반드시 이해해야 한다!]
 * 1. 상속 관계의 객체를 생성하면 그 내부에는 부모와 자식이 모두 생성된다.
 * 2. 상속 관계의 객체를 호출할 때, 대상 타입을 정해야 한다. 이때 호출자의 타입을 통해 대상 타입을 찾는다.
 * 3. 현재 타입에서 기능을 찾지 못하면 상위 부모 타입으로 기능을 찾아서 실행한다. 기능을 찾지 못하면 컴파일 오류가 발생한다.
 */
public class ElectricCar extends Car {
    public void charge(){
        System.out.println("충전합니다.");
    }

//    public void move(){
//        System.out.println("차2를 이동합니다.");
//    }
}

package poly.basic;

// 다운캐스팅을 자동으로 하지 않는 이유
public class CastingMain04 {
    public static void main(String[] args) {
        Parent parent1 = new Child();
        Child child1 = (Child) parent1;
        child1.childMethod(); // 문제 X

        Parent parent2 = new Parent();
        Child child2 = (Child) parent2; // 런타임 오류 - ClassCastException
        child2.childMethod(); // 오류 - 실행 불가
        /**
         * [업캐스팅이 안전하고 다운캐스팅이 위험한 이유]
         * 다운캐스팅의 경우, 인스턴스에 존재하지 않는 하위 타입으로 캐스팅하는 문제가 발생할 수 있다.
         * 왜냐하면 객체를 생성하면 부모 타입은 모두 함께 생성되지만 자식 타입은 생성되지 않는다.
         * 따라서 개발자가 이런 문제를 인지하고 사용해야 한다는 의미로 명시적으로 캐스팅을 해주어야 한다.
         */
    }
}

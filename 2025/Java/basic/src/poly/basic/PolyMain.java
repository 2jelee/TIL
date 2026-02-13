package poly.basic;

public class PolyMain {
    public static void main(String[] args) {
        // 부모 변수가 부모 인스턴스 참조
        System.out.println("Parent -> Parent");
        Parent parent = new Parent();
        parent.parentMethod();

        // 자식 변수가 자식 인스턴스 참조
        System.out.println("Child -> Child");
        Child child = new Child();
        child.parentMethod();
        child.childMethod();

        // 부모 변수가 자식 인스턴스 참조(다형적 참조)
        System.out.println("Parent -> Child");
        Parent poly = new Child(); // 부모 타입은 자식을 참조할 수 있다....???
        poly.parentMethod();
        /**
         * Parent poly = new Child(); 성공
         * Child poly2 = new Parent(); 불가능 => 컴파일 오류 발생 - 반대로 자식 타입은 부모 타입을 담을 수 없다.
         */
        // Child child1 = new Parent();
//        poly.childMethod(); // 불가 => 컴파일 오류 발생 - 자식의 기능 호출 불가.
        /**
         * 상속 관계는 부모 방향으로 찾아 올라갈 수는 있지만 자식 방향으로 찾아 내려갈 수는 없다.
         * `Parent` 는 부모 타입이고 상위에 부모가 없다. 따라서 `childMethod()` 를 찾을 수 없으므로 컴파일 오류가 발생한다.
         */
        /**
         * [다형적 참조]
         * `Parent` 타입의 변수는 다음과 같이 자신인 `Parent` 는 물론이고, 자식 타입까지 참조할 수 있다.
         * 만약 손자가 있다면 손자도 그 하위 타입도 참조할 수 있다.
         * `Parent poly = new Parent()`
         * `Parent poly = new Child()`
         * `Parent poly = new Grandson()` : `Child` 하위에 손자가 있다면 가능
         * => 자바에서 부모 타입은 자신은 물론이고 자신을 기준으로 모든 자식 타입을 참조할 수 있다.
         * 이것이 바로 다양한 형태를 참조할 수 있다고 해서 다형적 참조라 한다.
         */
    }
}

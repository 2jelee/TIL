package poly.basic;

public class CastingMain06 {
    public static void main(String[] args) {
        Parent parent1 = new Parent();
        System.out.println("parent1 호출");
        call(parent1);

        Parent parent2 = new Child();
        System.out.println("parent2 호출");
        call(parent2);
    }

    private static void call(Parent parent){
        parent.parentMethod();

        // Child 인스턴스인 경우, childMethod() 실행
        if(parent instanceof Child child) { // [기존] if(parent instanceof Child){
            System.out.println("Child 인스턴스가 맞다.");
//            Child child = (Child) parent; // 자바 16부터는 `instanceof` 를 사용하면서 동시에 변수를 선언할 수 있다.
            child.childMethod();
        }
    }
}

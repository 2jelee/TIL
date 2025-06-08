package poly.basic;

public class CastingMain05 {
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

        /**
         * 지금처럼 다운캐스팅을 수행하기 전에는 먼저 `instanceof` 를 사용해서 원하는 타입으로 변경이 가능한지
         * 확인한 다음에 다운캐스팅을 수행하는 것이 안전하다.
         *
         * 쉽게 이야기해서 오른쪽에 있는 타입에 왼쪽에 있는 인스턴스의 타입이 들어갈 수 있는지 대입해보면 된다.
         * 대입이 가능하면 `true` , 불가능하면 `false` 가 된다.
         *
         * [ex]
         * new Parent() instanceof Parent
         * Parent p = new Parent() //같은 타입 true
         *
         * new Child() instanceof Parent
         * Parent p = new Child() //부모는 자식을 담을 수 있다. true
         */
        if(parent instanceof Child){
            System.out.println("Child 인스턴스가 맞다.");
            Child child = (Child) parent;
            child.childMethod();
        }
//        else{
//            System.out.println("Child 인스턴스가 아님!");
//        }
    }
}

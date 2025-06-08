package extends01.super01;

public class Child extends Parent {
    public String value = "child";

    @Override
    public void hello(){
        System.out.println("Child.hello");
    }

    public void call(){
        System.out.println("this value = " + this.value); // this 생략 가능 -> this: 자기자신
        System.out.println("super value = " + super.value); // super: 부모

        this.hello();
        super.hello();
        // 실행 결과를 보면 `super` 를 사용한 경우 부모 클래스의 기능을 사용한 것을 확인할 수 있다.
    }
}

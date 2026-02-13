package poly.diamond;

public class Child implements InterfaceA, InterfaceB{
    @Override
    public void methodA() {
        System.out.println("Child.methodA");
    }

    // methodCommon의 경우 양쪽 인터페이스에 존재하나, 같은 메서드이므로 구현은 하나만 해도 O
    @Override
    public void methodCommon() {
        System.out.println("Child.methodCommon");
    }

    @Override
    public void methodB() {
        System.out.println("Child.methodB");
    }
}

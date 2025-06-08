package poly.ex04;

public class Dog extends AbstractAnimal {
    @Override
    public void sound() {
        System.out.println("멍멍쓰");
    }

    @Override
    public void move() {
        System.out.println("멍멍쓰의 이동");
    }
}

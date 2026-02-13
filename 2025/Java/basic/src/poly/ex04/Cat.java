package poly.ex04;

public class Cat extends AbstractAnimal {
    @Override
    public void sound() {
        System.out.println("야옹쓰");
    }

    @Override
    public void move() {
        System.out.println("야옹쓰의 이동");
    }
}

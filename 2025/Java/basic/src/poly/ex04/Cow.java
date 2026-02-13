package poly.ex04;

public class Cow extends AbstractAnimal {
    @Override
    public void sound() {
        System.out.println("음매쓰");
    }

    @Override
    public void move() {
        System.out.println("음매쓰의 이동");
    }
}

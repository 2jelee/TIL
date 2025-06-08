package poly.ex05;

/**
 * 인터페이스를 상속 받을 때는 `extends` 대신에 `implements` 라는 **구현**이라는 키워드를 사용해야 한다.
 * 인터페이스는 그래서 상속이라 하지 않고 '구현'이라 한다.
 */
public class Cat implements InterfaceAnimal{
    @Override
    public void move() {
        System.out.println("고양이 이동");

    }

    @Override
    public void sound() {
        System.out.println("야옹");

    }
}

package poly.ex05;

/**
 * extends 대신 implements -> 상속 대신 "구현"이라는 단어가 더 적합.
 * extends -> class를 상속받는다.
  */

public class Dog implements InterfaceAnimal {
    @Override
    public void move() {
        System.out.println("갱애쥐 이동");
    }

    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}

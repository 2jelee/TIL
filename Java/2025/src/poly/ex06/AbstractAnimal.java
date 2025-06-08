package poly.ex06;

public abstract class AbstractAnimal {
    public abstract void sound(); // 순수 추상

    // 상속을 목적으로 사용
    public void move(){
        System.out.println("동물이 이동합니다.");
    };
}

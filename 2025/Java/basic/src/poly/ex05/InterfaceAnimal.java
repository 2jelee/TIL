package poly.ex05;

/**
 * 자바는 순수 추상 클래스를 더 편리하게 사용할 수 있는 인터페이스라는 기능을 제공한다.
 * -> 실제로는 순수 추상 클래스라는 단어는 존재하지 않음.
 *
 * 순수 추상 클래스는 다음과 같은 특징을 가진다.
 * 1. 인스턴스를 생성할 수 없다.
 * 2. 상속시 모든 메서드를 오버라이딩 해야 한다.
 * 3. 주로 다형성을 위해 사용된다.
 *
 * 인터페이스는 앞서 설명한 순수 추상 클래스와 같다. 여기에 약간의 편의 기능이 추가된다.
 * 1. 인터페이스의 메서드는 모두 `public` , `abstract` 이다.
 * 2. 메서드에 `public abstract` 를 생략할 수 있다. 참고로 생략이 권장된다.
 * 3. 인터페이스는 다중 구현(다중 상속)을 지원한다.
 *
 */
public interface InterfaceAnimal {
    // public abstract 생략
    void move(); // public abstract void move(); 와 동일
    // 접근자는 public

    void sound();

}

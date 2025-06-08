package poly.ex02;

public class AnimalPolyMain01 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        soundAminal(dog);
        soundAminal(cat);
        soundAminal(cow);

    }

    /**
     * 이 코드의 핵심은 `Animal animal` 부분이다.
     * **다형적 참조** 덕분에 `animal` 변수는 자식인 `Dog` , `Cat` , `Caw` 의 인스턴스를 참조할 수 있다. (부모는 자식을 담을 수 있다)
     * **메서드 오버라이딩** 덕분에 `animal.sound()` 를 호출해도
     * `Dog.sound()` , `Cat.sound()` , `Caw.sound()` 와 같이 각 인스턴스의 메서드를 호출할 수 있다.
     * 만약 자바에 메서드 오버라이딩이 없었다면 모두 `Animal` 의 `sound()` 가 호출되었을 것이다
     */
    private static void soundAminal(Animal animal){ // 부모는 자식을 담을 수 있다! => Animal dog = new Dog();
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }
}

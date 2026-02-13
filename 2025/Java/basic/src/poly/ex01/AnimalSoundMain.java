package poly.ex01;

public class AnimalSoundMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        System.out.println("동물 소리 테스트 시작");
        dog.sound();
        System.out.println("동물 소리 테스트 종료");

        System.out.println("동물 소리 테스트 시작");
        cat.sound();
        System.out.println("동물 소리 테스트 종료");

        soundCow(cow);

//        Cow[] cowArr = {dog, cat, cow}; // type이 다르므로 불가.
        /**
         * 다형성의 핵심은 다형적 참조와 메서드 오버라이딩이다.
         * 이 둘을 활용하면 `Dog` , `Cat` , `Caw` 가 모두 같은 타입을 사용하고, 각자 자신의 메서드도 호출할 수 있다
         */
    }

    private static void soundCow(Cow cow){
        System.out.println("동물 소리 테스트 시작");
        cow.sound();
        System.out.println("동물 소리 테스트 종료");
    }
}

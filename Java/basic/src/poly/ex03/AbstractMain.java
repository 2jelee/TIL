package poly.ex03;

public class AbstractMain {
    public static void main(String[] args) {
        // AbstractAnimal animal = new AbstractAnimal(); 추상 클래스 생성 불가

        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        dog.sound();
        cat.sound();
        cow.sound();

        soundAnmiaml(dog);
        soundAnmiaml(cat);
        soundAnmiaml(cow);
    }

    private static void soundAnmiaml(AbstractAnimal animal){
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }
}

package poly.ex05;

public class InterfaceMain {
    public static void main(String[] args) {
//        InterfaceAnimal interfaceAnimal = new InterfaceAnimal(); // 인터페이스 생성 불가

        Cat cat = new Cat();
        Cow cow = new Cow();
        Dog dog = new Dog();

        soundAnimal(cat);
        soundAnimal(cow);
        soundAnimal(dog);
    }

    // 변하지 않는 부분
    private static void soundAnimal(InterfaceAnimal interfaceAnimal){
        System.out.println("동물 소리 테스트 시작");
        interfaceAnimal.sound();
        System.out.println("동물 소리 테스트 종료");
    }
}

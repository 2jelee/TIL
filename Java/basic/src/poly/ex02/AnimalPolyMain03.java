package poly.ex02;

public class AnimalPolyMain03 {
    public static void main(String[] args) {
        Animal[] animalArr = {new Dog(), new Cat(), new Cow()}; // 단축키 opt+cmd+N => inline variable

        for (Animal animal : animalArr) {
            soundAnimal(animal);
        }
    }

    // 변하지 않는 부분
    private static void soundAnimal(Animal animal) { // 단축키 opt+cmd+M => 해당 영역 추출하여 메서드 생성
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }


}

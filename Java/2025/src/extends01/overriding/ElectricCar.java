package extends01.overriding;

public class ElectricCar extends Car {
    /**
     * 오버라이딩한 메서드 위에 이 애노테이션을 붙여야 한다.
     * 컴파일러는 이 애노테이션을 보고 메서드가 정확히 오버라이드 되었는지 확인한다.
     * 오버라이딩 조건을 만족시키지 않으면 컴파일 에러를 발생시킨다. 따라서 실수로 오버라이딩을 못하는 경우를 방지해준다.
     * 예를 들어서 이 경우에 만약 부모에 `move()` 메서드가 없다면 컴파일 오류가 발생한다.
     * 참고로 이 기능은 필수는 아니지만 코드의 명확성을 위해 붙여주는 것이 좋다.
     */
    // 기능을 새로 재정의. => 메서드 오버라이딩
    @Override
    public void move(){
        System.out.println("전기차를 빠르게 이동합니다.");
    }

    public void charge(){
        System.out.println("충전합니다.");
    }
}

package poly.car1;

public class Driver {
    // 멤버변수로 Car를 가짐. => 멤버변수에 자동차를 실제로 설정.
    // 실제 인스턴스의 값을 참조값으로 설정.
    private Car car;

    public void setCar(Car car) {
        System.out.println("자동차를 설정합니다. "+ car);
        this.car = car;
    }

    public void drive(){
        System.out.println("자동차를 운전합니다.");
        car.startEngine();
        car.pressAccelerator();
        car.offEngine();
    }
}

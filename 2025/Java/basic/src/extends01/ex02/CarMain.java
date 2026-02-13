package extends01.ex02;

public class CarMain {
    /**
     * [단일 상속]
     * 자바는 클래스의 다중 상속을 허용하지 않는다. 대신에 이후에 설명한 인터페이스의 다중 구현을 허용해서 이러한 문제를 피한다
     */
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.move();
        electricCar.charge();

        GasCar gasCar = new  GasCar();
        gasCar.move();
        gasCar.fillUp();
    }
}

package poly.car1;

public class CarMain1 {
    public static void main(String[] args) {
        Driver driver = new Driver();

        // 차량 선택(K3)
        K3Car k3Car = new K3Car();
        // Car car = k3Car; // 아래와 동일 => 부모는 자식을 받을 수 있다.
        driver.setCar(k3Car);
        driver.drive();

        // 차량 변경(K3 -> Model3로)
        Model3Car model3Car = new Model3Car();
        driver.setCar(model3Car);
        driver.drive();

        // 차량 변경(Model3 -> newCar로)
        NewCar newCar = new NewCar();
        driver.setCar(newCar);
        driver.drive();

    }

}

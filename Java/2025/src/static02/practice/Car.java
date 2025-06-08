package static02.practice;

public class Car {
    private static String name;
    private static int countBuyCar; // private static int countBuyCar = 0; 도 가능

    public Car(String model) {
//        this.name = model;
//        System.out.println("차량 구입, 이름: " + name);

        System.out.println("차량 구입, 이름: " + model);
        this.name = model;
        countBuyCar++;
    }

    public static void showTotalCars(){
//        countBuyCar++;
        System.out.println("구매한 차량 수 : " + countBuyCar);

    }
}

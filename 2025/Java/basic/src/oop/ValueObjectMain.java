package oop;

public class ValueObjectMain {
    public static void main(String[] args) {
        ValueData valueData = new ValueData();
        valueData.add();
        valueData.add();
        valueData.add();
        System.out.println("최종 숫자 = "+valueData.value);
        /**
         * [정리]
         * 1. 클래스는 속성(데이터, 멤버변수)과 기능(메서드)을 정의할 수 있다.
         * 2. 객체는 자신의 메서드를 통해 자신의 멤버 변수에 접근할 수 있다.
         *    - 객체의 메서드 내부에서 접근하는 멤버 변수는 객체 자신의 멤버 변수이다.
         */
    }
}

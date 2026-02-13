package oop;

public class ValueData {
    int value;

    /**
     * **참고: 여기서 만드는 add() 메서드에는 static 키워드를 사용하지 않는다.**
     * 원칙: 메서드는 객체를 생성해야 호출할 수 있다.
     * 그런데 `static` 이 붙으면 객체를 생성하지 않고도 메서드를 호출할 수 있다.
     */
    void add(){
        value++;
        System.out.println("숫자 증가 value = "+ value);
    }
}

package static02;

public class DecoData {
    private int instanceValue;
    private static int staticValue;

    // static만 사용 가능 => 정적 변수, 정적 메서드에 접근 가능
    public static void staticCall(){
        staticValue++; // 정적 변수 접근
        staticMethod(); // 정적 메서드 접근

//        instanceValue++; // 인스턴스 변수 접근, compile error
//        instanceMethod(); // 인스턴스 메서드 접근, compile error
    }

    // 인스턴스 메서드 => 모든 곳에서 공용인 static을 호출할 수 있다. => 정적 변수, 정적 메서드에도 접근 가능.
    public void instanceCall(){
        instanceValue++;  // 인스턴스 변수에 접근
        instanceMethod();

        staticValue++; // 정적 변수 접근 => DecoData.staticValue 생략 가능.
        staticMethod(); // 정적 메서드 접근 => DecoData.staticMethod 생략 가능.
    }

    // 객체의 참조값을 직접 매개변수로 전달하면 정적 메서드도 인스턴스의 변수나 메서드를 호출할 수 있다.
    public static void staticCall(DecoData data){
        data.instanceValue++;
        data.instanceMethod();
    }

    private void instanceMethod(){
        System.out.println("instanceValue = "+instanceValue);
    }

    private static void staticMethod(){
        System.out.println("staticValue = " + staticValue);
    }
}

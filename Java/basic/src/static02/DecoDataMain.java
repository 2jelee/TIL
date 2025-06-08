package static02;

// static - 정적 메서드 import 가능
import static static02.DecoData.staticCall;
import static static02.DecoData.*; // 이 안에 있는 모든 메서드 쓰고 싶다면?

public class DecoDataMain {
    /**
     * 인스턴스 생성 없이 실행하는 가장 대표적인 메서드가 바로 `main()` 메서드이다.
     * `main()` 메서드는 프로그램을 시작하는 시작점이 되는데, 생각해보면 객체를 생성하지 않아도 `main()` 메서드가 작동했다.
     * 이것은 `main()` 메서드가 `static` 이기 때문이다. 정적 메서드는 정적 메서드만 호출할 수 있다.
     * 따라서 정적 메서드인 `main()` 이 호출하는 메서드에는 정적 메서드를 사용했다.
     * 물론 더 정확히 말하자면 정적 메서드는 같은 클래스 내부에서 정적 메서드만 호출할 수 있다.
     * 따라서 정적 메서드인 `main()` 메서드가 같은 클래스에서 호출하는 메서드도 정적 메서드로 선언해서 사용했다.
     */
    public static void main(String[] args) {
        System.out.println("1. 정적 호출");
//        DecoData.staticCall();
//        DecoData.staticCall();
//        DecoData.staticCall();
//        DecoData.staticCall();
        // 위 코드처럼 반복된다면? -> import static
        staticCall();

        System.out.println("2. 인스턴스 호출1");
        DecoData data1 = new DecoData();
        data1.instanceCall();

        System.out.println("2. 인스턴스 호출2");
        DecoData data2 = new DecoData();
        data2.instanceCall();

        DecoData.staticCall(data1);

        // 추가
        // 인스턴스를 통한 접근
        DecoData data3 = new DecoData();
        data3.staticCall(); // <- 이것도 가능은 하나, 마치 인스턴스에 있는 메서드 호출하는 것처럼 보이므로 이처럼 하지 않도록.

        // 클래스를 통한 접근
        DecoData.staticCall(); // static임을 바로 알 수 있음. 이 방법을 선호!
    }
}

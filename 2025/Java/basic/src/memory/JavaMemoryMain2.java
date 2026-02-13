package memory;

/**
 * [스택 영역과 힙 영역]
 * 이번에는 스택 영역과 힙 영역이 함께 사용되는 경우를 알아보자.

 * [정리]
 * 지역 변수는 스택 영역에, 객체(인스턴스)는 힙 영역에 관리되는 것을 확인했다.
 * 이제 나머지 하나가 남았다. 바로 메서드 영역이다. 메서드 영역이 관리하는 변수도 있다.
 * 이것을 이해하기 위해서는 먼저 `static` 키워드를 알아야 한다.
 * `static` 키워드는 메서드 영역과 밀접한 연관이 있다.
 */
public class JavaMemoryMain2 {
    public static void main(String[] args) {
        System.out.println("main start");
        method1();
        System.out.println("main end");
    }

    static void method1() {
        System.out.println("method1 start");
        Data data = new Data(10);
        method2(data);
        System.out.println("method1 end");
    }

    static void method2(Data data2) {
        System.out.println("method2 start");
        System.out.println("data.value = "+data2.getValue());
        System.out.println("method2 end");
    }

    /**
     * `main()` `method1()` `method2()` 순서로 호출하는 단순한 코드이다.
     * `method1()` 에서 `Data` 클래스의 인스턴스를 생성한다.
     * `method1()` 에서 `method2()` 를 호출할 때 매개변수에 `Data` 인스턴스의 참조값을 전달한다.
     * => method1()` 은 `method2()` 를 호출하면서 `Data data2` 매개변수에 `x001` 참조값을 넘긴다.
     * 이제 `method1()` 에 있는 `data1` 과 `method2()` 에 있는 `data2` 지역 변수(매개변수 포함)는 둘다 같은 `x001` 인스턴스를 참조한다.
     * -> `method2()` 가 종료된다. `method2()` 의 스택 프레임이 제거되면서 매개변수 `data2`도 함께 제거된다.
     * -> `method1()` 이 종료된다. `method1()` 의 스택 프레임이 제거되면서 지역 변수 `data1`도 함께 제거된다.
     * -> `method1()` 이 종료된 직후의 상태를 보자. `method1()` 의 스택 프레임이 제거되고 지역 변수 `data1`도 함께 제거되었다.
     * 이제 `x001` 참조값을 가진 `Data` 인스턴스를 참조하는 곳이 더는 없다. 참조하는 곳이 없으므로 사용되는 곳도 없다.
     * 결과적으로 프로그램에서 더는 사용하지 않는 객체인 것이다. 이런 객체는 메모리만 차지하게 된다.
     * GC(가비지 컬렉션)은 이렇게 참조가 모두 사라진 인스턴스를 찾아서 메모리에서 제거한다.
     */
    // **참고**: 힙 영역 외부가 아닌, 힙 영역 안에서만 인스턴스끼리 서로 참조하는 경우에도 GC의 대상이 된다.
}

package access.a;

public class PublicClass {
    public static void main(String[] args) {
        // 자기 자신을 생성
        PublicClass publicClass = new PublicClass();
        DefaultClass1 class1 = new DefaultClass1();
        DefaultClass2 class2 = new DefaultClass2();
    }
    /**
     * `PublicClass` 라는 이름의 클래스를 만들었다. 이 클래스는 `public` 접근 제어자다.
     * 따라서 파일명과 이 클래스의 이름이 반드시 같아야 한다. 이 클래스는 `public` 이기 때문에 외부에서 접근할 수 있다.
     * `DefaultClass1` , `DefaultClass2` 는 `default` 접근 제어자다. 이 클래스는 `default` 이기 때문에 같은 패키지 내부에서만 접근할 수 있다.
     * `PublicClass` 의 `main()` 을 보면 각각의 클래스를 사용하는 예를 보여준다.
     * - `PublicClass` 는 `public` 접근 제어다. 따라서 어디서든 사용할 수 있다. `DefaultClass1` , `DefaultClass2` 와는 같은 패키지에 있으므로 사용할 수 있다.
     */
}

// 아래 default
class DefaultClass1{

}
class DefaultClass2{

}
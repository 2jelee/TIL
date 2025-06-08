package static01;

public class Data03 {
    public String name; // 인스턴스 변수 (=static이 없는 변수)

    /**
     * 특정 클래스에서 공용으로 함께 사용할 수 있는 변수를 만들 수 있다면 편리할 것이다.
     * `static` 키워드를 사용하면 공용으로 함께 사용하는 변수를 만들 수 있다.
     * `static` 이 붙은 멤버 변수는 '메서드 영역에서 관리'한다. => 즉, 공용으로 쓸거다.
     */
    public static int count; // static
    // 이처럼 멤버변수에 static을 붙이게 되면 static 변수, 정적 변수, 또는 클래스 변수라고 한다.

    public Data03(String name){
        this.name = name;
        count++; // Data03.count++; => 같은 클래스 내에서는 Data03 생략 가능
    }

    /**
     * `static` 변수는 쉽게 이야기해서 클래스인 붕어빵 틀이 특별히 관리하는 변수이다.
     * 붕어빵 틀은 1개이므로 클래스 변수도 하나만 존재한다. 반면에 인스턴스 변수는 붕어빵인 인스턴스의 수 만큼 존재한다.
     */
}

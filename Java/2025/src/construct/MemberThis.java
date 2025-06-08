package construct;

public class MemberThis {
    String nameField; // 멤버변수

    void initMember(String memberParam){ // 매개변수 = 지역변수
        nameField = memberParam; // 매개변수와 자신의 멤버변수가 다르므로 this 없어도 O
//        this.nameField = memberParam; // 매개변수와 자신의 멤버변수가 다르므로 this 없어도 O
    }
    /**
     * [this와 코딩 스타일]
     * 다음과 같이 멤버 변수에 접근하는 경우에 항상 `this` 를 사용하는 코딩 스타일도 있다.
     * `this.nameField` 를 보면 `this` 를 생략할 수 있지만, 생략하지 않고 사용해도 된다.
     * 이렇게 `this` 를 사용하면 이 코드가 멤버 변수를 사용한다는 것을 눈으로 쉽게 확인할 수 있다.
     * 그래서 과거에 이런 스타일을 많이 사용하기도 했다. 쉽게 이야기해서 `this` 를 강제로 사용해서,
     * 지역 변수(매개변수)와 멤버 변수를 눈에 보이도록 구분하는 것이다. => 결국 this는 구분하려고 쓰는 것.
     * 하지만 최근에 IDE가 발전하면서 IDE가 멤버 변수와 지역 변수를 색상으로 구분해준다.
     * 다음을 보면 멤버 변수와 지역 변수의 색상이 다른 것을 확인할 수 있다.
     * => 결론
     * 이런 점 때문에 `this` 는 앞서 설명한 것 처럼 이름이 중복되는 것 처럼,
     * 꼭 필요한 경우에만 사용해도 충분하다 생각한다.
     * => 왜 쓰는가?로 생각하자
     */
}

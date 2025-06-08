package construct;

/**
 * [생성자 호출]
 * 생성자는 인스턴스를 생성하고 나서 즉시 호출된다.
 * 생성자를 호출하는 방법은 다음 코드와 같이 `new` 명령어 다음에생성자 이름과 매개변수에 맞추어 인수를 전달하면 된다.
 * new 생성자이름(생성자에 맞는 인수 목록)
 * new 클래스이름(생성자에 맞는 인수 목록)
 * 참고로 생성자이름이 클래스 이름이기 때문에 둘다 맞는 표현이다.
 *
 * 참고로 `new` 키워드를 사용해서 객체를 생성할 때 마지막에 괄호`()`도 포함해야 하는 이유가 바로 생성자 때문이다.
 * 객체를 생성하면서 동시에 생성자를 호출한다는 의미를 포함한다.
 */
public class ConstructMain1 {
    public static void main(String[] args) {
        // 객체 생성과 동시에 생성자를 호출.
        MemberConstruct member1 = new MemberConstruct("user1", 15, 90); // 단축키: cmd+P로 필요한 파라미터 알 수 있음
        MemberConstruct member2 = new MemberConstruct("user2", 16, 80);
//        MemberConstruct member3 = new MemberConstruct(); // 직접 정의한 생성자를 호출하지 않으면 컴파일 오류가 발생!
        // 컴파일 오류 메시지
        //no suitable constructor found for MemberConstruct(no arguments)

        MemberConstruct[] memberConstructs = {member1, member2};
        for (MemberConstruct s : memberConstructs) {
            System.out.println("이름: "+ s.name + " 나이: "+s.age+" 성적: "+s.grade);
        }
    }
    /**
     * [생성자 장점]
     * 1. 중복 제거
     * 2. 제약 - 생성자 호출 필수
     *
     * **중복 호출 제거**
     * 생성자가 없던 시절에는 생성 직후에 어떤 작업을 수행하기 위해 다음과 같이 메서드를 직접 한번 더 호출해야 했다.
     * 생성자 덕분에 객체를 생성하면서 동시에 생성 직후에 필요한 작업을 한번에 처리할 수 있게 되었다.
     *
     * **제약 - 생성자 호출 필수**
     * 방금 코드에서 생성자 등장 전 코드를 보자. 이 경우 `initMember(...)` 를 실수로 호출하지 않으면 어떻게 될까?
     * 이 메서드를 실수로 호출하지 않아도 프로그램은 작동한다. 하지만 회원의 이름과 나이, 성적 데이터가 없는 상태로 프로그램이 동작하게 된다.
     * 만약에 이 값들을 필수로 반드시 입력해야 한다면, 시스템에 큰 문제가 발생할 수 있다.
     * 생성자의 진짜 장점은 객체를 생성할 때 직접 정의한 생성자가 있다면 **직접 정의한 생성자를 반드시 호출**해야 한다는 점이다.
     * 참고로 생성자를 메서드 오버로딩 처럼 여러개 정의할 수 있는데, 이 경우에는 하나만 호출하면 된다.
     * `MemberConstruct` 클래스의 경우 다음 생성자를 직접 정의했기 때문에 직접 정의한 생성자를 반드시 호출해야 한다.
     *
     * [생성자를 사용하면 필수값 입력을 보장할 수 있다.]
     * **참고:**
     * 좋은 프로그램은 무한한 자유도가 주어지는 프로그램이 아니라 적절한 제약이 있는 프로그램이다.
     */
}

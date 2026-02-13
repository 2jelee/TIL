package construct;

public class MemberInit {
    String name;
    int age;
    int grade;

    // 추가
    void initMember(String name, int age, int grade){
        // 가까운 scope(위 => 매개변수)가 더 우선순위를 가진다.
        // 여기서 this는 자기 자신의 인스턴스를 가리킨다.(인스턴스 자신의 참조값을 기리킨다.)
        this.name = name; // 1. 오른쪽의 name은 매개변수에 접근.
        this.age = age;
        this.grade = grade;
        /**
         * [this의 생략]
         * 이 경우 변수를 찾을 떄 가까운 지역변수(매개변수도 지역변수임.)를 먼저 찾고
         * 없으면 그 다음으로 멤버변수를 찾는다. 멤버변수도 없으면 오류가 발생.
         */
    }
}

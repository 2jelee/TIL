package construct;

public class MethodInitMain2 {
    public static void main(String[] args) {
        MemberInit member1 = new MemberInit();
        initMember(member1, "user1", 15, 90);

        MemberInit member2 = new MemberInit();
        initMember(member2, "user2", 16, 80);

        MemberInit[] members = {member1, member2};

        for (MemberInit m: members) {
            System.out.println("이름: "+ m.name + " 나이: "+m.age+" 성적: "+m.grade);
        }
    }

    /**
     * `initMember(...)` 메서드를 사용해서 반복을 제거했다.
     * 그런데 이 메서드는 대부분 `MemberInit` 객체의 멤버 변수를 사용한다. 우리는 앞서 객체 지향에 대해서 학습했다.
     * 이런 경우 속성과 기능을 한 곳에 두는 것이 더 나은 방법이다.
     * 쉽게 이야기해서 `MemberInit` 이 자기 자신의 데이터를 변경하는 기능(메서드)을 제공하는 것이 좋다.
     */
    static void initMember(MemberInit member, String name, int age, int grade){
        member.name = name;
        member.age = age;
        member.grade = grade;
    }
}

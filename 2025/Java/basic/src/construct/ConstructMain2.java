package construct;

public class ConstructMain2 {
    public static void main(String[] args) {
        // 객체 생성과 동시에 생성자를 호출.
        MemberConstruct member1 = new MemberConstruct("user1", 15, 90);
        MemberConstruct member2 = new MemberConstruct("user2", 16); // 추가로 만든 2번째 생성자 호출

        MemberConstruct[] memberConstructs = {member1, member2};

        for (MemberConstruct s : memberConstructs) {
            System.out.println("이름: "+ s.name + " 나이: "+s.age+" 성적: "+s.grade);
        }
        /**
         * 생성자를 오버로딩 한 덕분에 성적 입력이 꼭 필요한 경우에는 `grade` 가 있는 생성자를 호출하면 되고,
         * 그렇지 않은 경우에는 `grade` 가 없는 생성자를 호출하면 된다. `grade` 가 없는 생성자를 호출하면 성적은 `50` 점이 된다.
         */
        /**
         * [출력]
         * 생성자 호출 name = user1,age = 15, grade = 90  => "생성자 호출": this()로 첫번째 생성자를 불렀으므로
         * 생성자 호출 name = user2,age = 16, grade = 50
         * 이름: user1 나이: 15 성적: 90
         * 이름: user2 나이: 16 성적: 50
         */
    }
}

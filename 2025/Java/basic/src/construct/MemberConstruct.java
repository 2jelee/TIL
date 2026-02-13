package construct;

public class MemberConstruct {
    String name;
    int age;
    int grade;

    // [생성자] 클래스 이름과 같게 만듦.
    /**
     * 생성자는 메서드와 비슷하지만 다음과 같은 차이가 있다.
     * 생성자의 이름은 클래스 이름과 같아야 한다. 따라서 첫 글자도 대문자로 시작한다.
     * 생성자는 반환 타입이 없다. 비워두어야 한다.
     * 나머지는 메서드와 같다.
     */
    MemberConstruct(String name, int age, int grade){
        System.out.println("생성자 호출 name = "+ name+ ",age = " + age + ", grade = "+ grade);
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // 생성자 추가
//    MemberConstruct(String name, int age){
//        this.name = name;
//        this.age = age;
//        this.grade = 50;
//    }
    // 중복을 제거
    MemberConstruct(String name, int age){
        this(name, age, 50); // 중복 제거하여 변경
        // 위 this()는 생성자 안에서만 쓸 수 있음. => 매개변수 3가지 받는 생성자를 호출하는 것.
        /**
         *  this.name = name;
         *  this.age = age;
         *  this.grade = grade;
         */
        /**
         * 이때 `this()` 라는 기능을 사용하면 생성자 내부에서 자신의 생성자를 호출할 수 있다.
         * 참고로 `this` 는 인스턴스 자신의 참조값을 가리킨다. 그래서 자신의 생성자를 호출한다고 생각하면 된다.
         *
         * [this() 규칙]
         * `this()` 는 생성자 내부에서 코드의 첫줄에만 작성할 수 있다.
         * 다음은 규칙 위반이다. 이 경우 컴파일 오류가 발생한다.
         * public MemberConstruct(String name, int age) {
         *      System.out.println("go"); // << 불가
         *      this(name, age, 50);
         * }
         * `this()` 가 생성자 코드의 첫줄에 사용되지 않았다.
         */
    }

}

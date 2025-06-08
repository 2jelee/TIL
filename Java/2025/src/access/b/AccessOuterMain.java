package access.b;

import access.a.AccessData;

public class AccessOuterMain {
    public static void main(String[] args) {
        AccessData accessData = new AccessData();
        // public 호출 가능
        accessData.publicField = 1;
        accessData.publicMethod();

        // default => 같은 패키지 호출 가능 => 현재 다른 패키지(b)이므로 호출 불가
//        accessData.defaultField = 2;
//        accessData.defaultMethod();

        // private => 호출 불가
//        accessData.privateField = 3;
//        accessData.privateMethod();

        accessData.innerAccess();
        /**
         * 접근 제어자 사용 - 클래스 레벨
         * [클래스 레벨의 접근 제어자 규칙]
         * 1.클래스 레벨의 접근 제어자는 `public` , `default` 만 사용할 수 있다.
         * - `private` , `protected` 는 사용할 수 없다.
         * 2.`public` 클래스는 반드시 파일명과 이름이 같아야 한다.
         * - 하나의 자바 파일에 `public` 클래스는 하나만 등장할 수 있다.
         * - 하나의 자바 파일에 `default` 접근 제어자를 사용하는 클래스는 무한정 만들 수 있다.
         */
    }
}

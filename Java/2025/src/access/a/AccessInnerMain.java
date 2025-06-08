package access.a;

public class AccessInnerMain {
    public static void main(String[] args) {
        AccessData accessData = new AccessData();
        // public 호출 가능
        accessData.publicField = 1;
        accessData.publicMethod();

        // default => 같은 패키지 호출 가능
        accessData.defaultField = 2;
        accessData.defaultMethod();

        // private => 호출 불가
//        accessData.privateField = 3;
//        accessData.privateMethod();

        accessData.innerAccess();
        /**
         * `AccessData.innerAccess()` 메서드는 `public` 이다. 따라서 외부에서 호출할 수 있다.
         * `innerAccess()` 메서드는 외부에서 호출되었지만 `innerAccess()` 메서드는 `AccessData` 에 포함되어있다.
         * 이 메서드는 자신의 `private` 필드와 메서드에 모두 접근할 수 있다.
         */
    }
}

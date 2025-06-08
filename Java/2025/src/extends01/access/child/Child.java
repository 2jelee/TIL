package extends01.access.child;

import extends01.access.parents.Parent;

public class Child extends Parent {
    /**
     * `publicValue = 1` : 부모의 `public` 필드에 접근한다. `public` 이므로 접근할 수 있다.
     * `protectedValue = 1` : 부모의 `protected` 필드에 접근한다. 자식과 부모는 다른 패키지이지만,
     *                        **상속 관계이므로 접근할 수 있다.**
     * `defaultValue = 1` : 부모의 `default` 필드에 접근한다. 자식과 부모가 다른 패키지이므로 접근할 수 없다.
     * `privateValue = 1` : 부모의 `private` 필드에 접근한다. `private` 은 모든 외부 접근을 막으므로 자식이라도 호출할 수 없다.
     */
    public void call(){
        publicValue = 1;
        protectedValue = 1; // 상속 관계 or 같은 패키지
        // defaultValue = 1; // 다른 패키지 접근 불가, 컴파일 오류
        //privateValue = 1; // 접근 불가, 컴파일 오류

        publicMethod();
        protectedMethod();
//        defaultMethod(); // 접근 불가
//        privateMethod(); // 접근 불가

        printParent();
    }
}

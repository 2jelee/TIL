package final01;

public class FieldInit {
    static final int CONST_VALUE = 10; // static final => 상수
    /**
     * 상수는 변하지 않고, 항상 일정한 값을 갖는 수를 말한다.
     * 자바에서는 보통 단 하나만 존재하는 변하지 않는 고정된 값을 상수라 한다.
     * 이런 이유로 상수는 `static final` 키워드를 사용한다.
     *
     * [Java 상수 특징]
     * - 필드를 직접 접근해서 사용한다.
     *  - 상수는 기능이 아니라 고정된 값 자체를 사용하는 것이 목적이다.
     *  - 상수는 값을 변경할 수 없다. 따라서 필드에 직접 접근해도 데이터가 변하는 문제가 발생하지 않는다.
     */
    final int value = 10; // 여러번 중복해서 불러야한다면 위와 같이 static final로 만들어 사용.

//    public FieldInit(int value){
//        this.value = value;
//    }
}

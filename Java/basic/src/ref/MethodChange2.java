package ref;

// 참조형과 메서드 호출
public class MethodChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        System.out.println("메서드 호출 전: dataA.value = " + dataA.value); // 10
        changeReference(dataA);
        System.out.println("메서드 호출 후: dataA.value = " + dataA.value); // 20
        /**
         * 기본형일 경우에는 값이 변하지 않으나, 참조형일 때 값이 바뀐다.
         * WHY?
         * 자바에서 변수에 값을 대입하는 것은 항상 값을 복사해서 대입한다. 변수 `dataA` 는 참조값 `x001` 을 가지고 있으므로
         * 참조값을 복사해서 전달했다. 따라서 변수 `dataA` , `dataX` 둘다 같은 참조값인 `x001` 을 가지게 된다.
         * 이제 `dataX` 를 통해서도 `x001` 에 있는 `Data` 인스턴스에 접근할 수 있다.
         * => Data dataX = dataA
         *
         * **기본형과 참조형의 메서드 호출**
         * 자바에서 메서드의 매개변수(파라미터)는 항상 값에 의해 전달된다. 그러나 이 값이 실제 값이냐, 참조(메모리 주소)값
         * 이냐에 따라 동작이 달라진다.
         * **기본형**: 메서드로 기본형 데이터를 전달하면, 해당 값이 복사되어 전달된다.
         * 이 경우, 메서드 내부에서 매개변수(파라미터)의 값을 변경해도, 호출자의 변수 값에는 영향이 없다.
         * **참조형**: 메서드로 참조형 데이터를 전달하면, 참조값이 복사되어 전달된다.
         * 이 경우, 메서드 내부에서 매개변수(파라미터)로 전달된 객체의 멤버 변수를 변경하면, 호출자의 객체도 변경된다.
         */
    }
    static void changeReference(Data dataX) {
        dataX.value = 20;
    }
}

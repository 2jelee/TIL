package poly.ex03;

//public class AbstractAnimal {
public abstract class AbstractAnimal { // => 인스턴스 직접 생성 불가. ex) AbstractAnimal aa = new AbstractAnimal 불가

    /**
     * - 추상 메서드는 선언할 때 메서드 앞에 추상이라는 의미의 `abstract` 키워드를 붙여주면 된다.
     * - **추상 메서드가 하나라도 있는 클래스는 추상 클래스로 선언해야 한다.**
     *   그렇지 않으면 컴파일 오류가 발생한다.
     *   추상 메서드는 메서드 바디가 없다. 따라서 작동하지 않는 메서드를 가진 불완전한 클래스로 볼 수 있다.
     *   따라서 직접 생성하지 못하도록 추상 클래스로 선언해야 한다.
     */
    public abstract void sound(); // Body 없음 {}
    // 추상 메서드는 자식 클래스가 반드시 오버라이딩 해야 하기 때문에 메서드 바디 부분이 없다. 바디 부분을 만들면 컴파일 오류가 발생한다.
    /**
     * 오버라이딩 하지 않으면 자식도 추상 클래스가 되어야 한다.
     * 추상 메서드는 기존 메서드와 완전히 같다. 다만 메서드 바디가 없고,
     * 자식 클래스가 해당 메서드를 반드시 오버라이딩 해야 한다는 제약이 추가된 것이다.
     */

    public void move(){
        System.out.println("동물이 움직입니다.");
    }
}

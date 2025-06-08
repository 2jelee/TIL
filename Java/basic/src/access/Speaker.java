package access;

/**
 * [접근 제어자 종류]
 * 자바는 4가지 종류의 접근 제어자를 제공한다.
 * **접근 제어자의 종류**
 * `private` : 모든 외부 호출을 막는다. => 클래스 안에서만 허용
 * `default` (=package-private): 같은 패키지안에서 호출은 허용한다. => 패키지 안에서만 허용
 * `protected` : 같은 패키지안에서 호출은 허용한다. 패키지가 달라도 상속 관계의 호출은 허용한다. => 패키지 + 상속 관계까지만 허용
 * `public` : 모든 외부 호출을 허용한다.
 * 순서대로 `private` 이 가장 많이 차단하고, `public` 이 가장 많이 허용한다.
 * `private -> default -> protected -> public`
 * 참고로 `protected` 는 상속 관계에서 자세히 설명한다.
 *
 * [접근 제어자 사용 위치]
 * 접근제어자는 필드, 메서드, 생성자에 사용된다.
 * 추가로 클래스 레벨에서도 일부 접근 제어자를 사용할 수 있다.
 */
/**
 * **package-private**
 * 접근 제어자를 명시하지 않으면 같은 패키지 안에서 호출을 허용하는 `default` 접근 제어자가 적용된다.
 * `default` 라는 용어는 해당 접근 제어자가 기본값으로 사용되기 때문에 붙여진 이름이지만, 실제로는 `package-private` 이 더 정확한 표현이다.
 * 왜냐하면 해당 접근 제어자를 사용하는 멤버는 동일한 패키지 내의 다른 클래스에서만 접근이 가능하기 때문이다.
 * 참고로 두 용어를 함께 사용한다.
 */
/**
 *  **접근 제어자의 핵심은 속성과 기능을 외부로부터 숨기는 것이다.**
 * `private` 은 나의 클래스 안으로 속성과 기능을 숨길 때 사용, 외부 클래스에서 해당 기능을 호출할 수 없다.
 * `default` 는 나의 패키지 안으로 속성과 기능을 숨길 때 사용, 외부 패키지에서 해당 기능을 호출할 수 없다.
 * `protected` 는 상속 관계로 속성과 기능을 숨길 때 사용, 상속 관계가 아닌 곳에서 해당 기능을 호출할 수 없다.
 * `public` 은 기능을 숨기지 않고 어디서든 호출할 수 있게 공개한다.
 */
public class Speaker {
//    int volume; // << 이는 default
    // private => Speaker 클래스 내부에서만 관리
    private int volume;

    // 생성자를 통해 초기 음량값 지정
    Speaker(int volume){
        this.volume = volume;
    }

    // 메서드 3개
    void volumeUp(){
        if(volume >= 100){
            System.out.println("음량을 증가시킬 수 없습니다. 최대 음량입니다.");
        } else{
            volume += 10;
            System.out.println("음량을 10 증가시킵니다.");
        }
    }

    void volumeDown(){
        volume -= 10;
        System.out.println("volumeDown 호출");
    }

    void showVolume(){
        System.out.println("현재 음량 : "+volume);
    }

}


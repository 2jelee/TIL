package oop;

// 음악 플레이어를 사용하는데 모든 속성과 기능이 하나의 클래스에 포함되어 있다.

/**
 * [캡슐화]
 * `MusicPlayer` 를 보면 음악 플레이어를 구성하기 위한 속성과 기능이 마치 하나의 캡슐에 쌓여있는 것 같다.
 * 이렇게 속성과 기능을 하나로 묶어서 필요한 기능을 메서드를 통해 외부에 제공하는 것을 캡슐화라 한다.
 *
 * 객체 지향 프로그래밍 덕분에 음악 플레이어 객체를 사용하는 입장에서 진짜 음악 플레이어를 만들고 사용하는 것처럼 친숙하게 느껴진다.
 * 그래서 코드가 더 읽기 쉬운 것은 물론이고, 속성과 기능이 한 곳에 있기 때문에 변경도 더 쉬워진다.
 */
public class MusicPlayer {
    int volume = 0;
    boolean isOn = false;

    void on(){
        // 자신의 멤버변수에 있는 속성을 바꾼다.
        isOn = true;
        System.out.println("음악 플레이어를 시작합니다");
    }
    void off(){
        isOn = false;
        System.out.println("음악 플레이어를 종료합니다");
    }

    void volumeUp(){
        volume++;
        System.out.println("음악 플레이어 볼륨:" + volume);
    }

    void volumeDown(){
        volume--;
        System.out.println("음악 플레이어 볼륨:" + volume);
    }

    void showStatus(){
        System.out.println("음악 플레이어 상태 확인");
        if (isOn) {
            System.out.println("음악 플레이어 ON, 볼륨:" + volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }
    }
}

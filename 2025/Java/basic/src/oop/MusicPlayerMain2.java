package oop;

/**
 * 문제: 음악 플레이어 만들기
 * 음악 플레이어를 만들어보자.
 * **요구 사항:**
 * 1. 2. 3. 음악 플레이어를 켜고 끌 수 있어야 한다.
 * 음악 프레이어의 볼륨을 증가, 감소할 수 있어야 한다.
 * 음악 플레이어의 상태를 확인할 수 있어야 한다.
 *
 * **예시 출력:**
 * 음악 플레이어를 시작합니다
 * 음악 플레이어 볼륨:1
 * 음악 플레이어 볼륨:2
 * 음악 플레이어 볼륨:1
 * 음악 플레이어 상태 확인
 * 음악 플레이어 ON, 볼륨:1
 * 음악 플레이어를 종료합니다.
 *
 * 앞서 작성한 코드에 클래스를 도입하자. `MusicPlayerData` 라는 클래스를 만들고, 음악 플레이어에 사용되는 데이터
 * 들을 여기에 묶어서 멤버 변수로 사용하자.
 */
public class MusicPlayerMain2 {
    public static void main(String[] args) {
        // 절차 지향 프로그래밍을 하되, 데이터 묶어 편리하게 관리.
        MusicPlayerData musicPlayerData = new MusicPlayerData();
        // 기존에 있던 지역변수 제거
//        int volume = 0;
//        boolean isOn = false;

        //음악 플레이어 켜기
        musicPlayerData.isOn = true;
        System.out.println("음악 플레이어를 시작합니다");
        //볼륨 증가
        musicPlayerData.volume++;
        System.out.println("음악 플레이어 볼륨:" + musicPlayerData.volume);
        //볼륨 증가
        musicPlayerData.volume++;
        System.out.println("음악 플레이어 볼륨:" + musicPlayerData.volume);
        //볼륨 감소
        musicPlayerData.volume--;
        System.out.println("음악 플레이어 볼륨:" + musicPlayerData.volume);
        //음악 플레이어 상태
        System.out.println("음악 플레이어 상태 확인");
        if (musicPlayerData.isOn) {
            System.out.println("음악 플레이어 ON, 볼륨:" + musicPlayerData.volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }
        //음악 플레이어 끄기
        musicPlayerData.isOn = false;
        System.out.println("음악 플레이어를 종료합니다");
    }
}

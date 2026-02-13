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
 * 앞서 작성한 코드에 클래스를 도입하자. `MusicPlayerData` 라는 클래스를 만들고, 음악 플레이어에 사용되는 데이터들을
 * 여기에 묶어서 멤버 변수로 사용하자.
 */
public class MusicPlayerMain3 {
    public static void main(String[] args) {
        // 절차 지향 프로그래밍을 하되, 데이터 묶어 편리하게 관리.
        // "절차 지향" << 순서를 중요시.
        // 메서드 추출.
        /**
         * 각각의 기능을 메서드로 만들어 각각의 기능이 모듈화 되었다.
         * [장점]
         * 1. 중복 제거: 로직 중복 제거. 같은 로직이 필요하면 해당 메서드를 여러번 호출하면 됨.
         * 2. 변경 영향 범위: 기능을 수정할 때 해당 메서드 내부만 변경하면 된다.
         * 3. 메서드 이름 추가: 메서드 이름을 통해 코드를 더 쉽게 이해.
         * "모듈화"
         * 여기서는 음악 플레이어의 기능이 필요하면 해당 기능을 메서드 호출 만으로 손쉽게 사용할 수 있다.
         * 이제 음악 플레이어와 관련된 메서드를 조립해서 프로그램을 작성할 수 있다.
         */
        MusicPlayerData musicPlayerData = new MusicPlayerData();

        //음악 플레이어 켜기
        on(musicPlayerData);
        //볼륨 증가
        volumeUp(musicPlayerData);
        volumeUp(musicPlayerData);
        //볼륨 감소
        volumeDown(musicPlayerData);

        //음악 플레이어 상태
        showStatus(musicPlayerData);
        // 음악 플레이어 끄기
        off(musicPlayerData);
    }

    static void on(MusicPlayerData musicPlayerData){
        musicPlayerData.isOn = true;
        System.out.println("음악 플레이어를 시작합니다");
    }
    static void off(MusicPlayerData musicPlayerData){
        musicPlayerData.isOn = false;
        System.out.println("음악 플레이어를 종료합니다");
    }

    static void volumeUp(MusicPlayerData musicPlayerData){
        musicPlayerData.volume++;
        System.out.println("음악 플레이어 볼륨:" + musicPlayerData.volume);
    }

    static void volumeDown(MusicPlayerData musicPlayerData){
        musicPlayerData.volume--;
        System.out.println("음악 플레이어 볼륨:" + musicPlayerData.volume);
    }

    static void showStatus(MusicPlayerData musicPlayerData){
        System.out.println("음악 플레이어 상태 확인");
        if (musicPlayerData.isOn) {
            System.out.println("음악 플레이어 ON, 볼륨:" + musicPlayerData.volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }
    }
    /**
     * [절차 지향 프로그래밍의 한계]
     * `MusicPlayerData` -> 음악 플레이어의 데이터가 존재
     * `MusicPlayerMain` -> 그 데이터를 사용하는 기능은 이 클래스 안에 있는 각각의 메서드에 분리되어 있음.
     * => 음악 플레이어와 관련된 데이터는 `MusicPlayerData` 를 사용해야 하고,
     * 음악 플레이어와 관련된 기능은 `MusicPlayerMain3` 의 각 메서드를 사용해야 한다.
     * 따라서 이후에 관련 데이터가 변경되면 `MusicPlayerMain3` 부분의 메서드들도 함께 변경해야 한다.
     * 그리고 이렇게 데이터와 기능이 분리되어 있으면 유지보수 관점에서도 관리 포인트가 2곳으로 늘어난다.
     */
}

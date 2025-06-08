package access;

public class SpeakerMain {
    public static void main(String[] args) {
        Speaker speaker = new Speaker(90); // 초기 음량은 90으로 지정.
        speaker.showVolume();

        speaker.volumeUp();
        speaker.showVolume();

        speaker.volumeUp();
        speaker.showVolume();

        speaker.volumeUp();
        speaker.showVolume();

        System.out.println("---volume 필드 직접 접근하여 수정---");
//        speaker.volume = 200; // << volume 필드에 private을 붙임으로써 접근 불가.
        speaker.showVolume();
        /**
         * `Speaker` 객체를 사용하는 사용자는 `Speaker` 의 `volume` 필드와 메서드에 모두 접근할 수 있다.
         * 앞서 `volumeUp()` 과 같은 메서드를 만들어서 음량이 100을 넘지 못하도록 기능을 개발했지만 소용이 없다.
         * 왜냐하면 `Speaker` 를 사용하는 입장에서는 `volume` 필드에 직접 접근해서 원하는 값을 설정할 수 있기 때문이다.
         * 이런 문제를 근본적으로 해결하기 위해서는 `volume` 필드의 외부 접근을 막을 수 있는 방법이 필요하다.
         * => 해결: 접근제어자
         */
        // **참고:** 좋은 프로그램은 무한한 자유도가 주어지는 프로그램이 아니라 적절한 제약을 제공하는 프로그램이다.
    }
}

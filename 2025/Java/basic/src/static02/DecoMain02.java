package static02;

public class DecoMain02 {
    public static void main(String[] args) {
        String str = "Hello java";
        // static이 붙은 정적 메서드는 객체 생성 없이 클래스명 + . + 메서드명으로 바로 호출 가능.
        // => 정적 메서드 덕불에 불필요한 객체생성 없이 편리하게 메서드를 사용.
        String deco = DecoUtil02.deco(str);

        System.out.println(deco);
    }
}

package poly.basic;

public class CastingMain02 {
    public static void main(String[] args) {
        // 부모 변수가 자식 인스턴스를 참조 => 다형적 참조
        Parent parentPoly = new Child();
        // 단, 자식의 기능은 호출 불가 - 컴파일 오류 발생
//        parentPoly.childMethod();

        // 일시적 다운캐스팅 - 해당 메서드를 호출하는 순간만 다운캐스팅
        ((Child)parentPoly).childMethod();
    }
}

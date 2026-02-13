package poly.basic;

public class CastingMain01 {
    public static void main(String[] args) {
        // 부모 변수가 자식 인스턴스를 참조 => 다형적 참조
        Parent parentPoly = new Child();
        // 단, 자식의 기능은 호출 불가 - 컴파일 오류 발생
//        parentPoly.childMethod();

        // 다운 캐스팅 (부모 -> 자식 타입으로 변환)
        Child child = (Child) parentPoly;
        child.childMethod();
    }
}

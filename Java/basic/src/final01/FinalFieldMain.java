package final01;

public class FinalFieldMain {
    public static void main(String[] args) {
        // final 필드 - 생성자 초기화
        System.out.println("생성자 초기화");
        ConstructInit constructInit01 = new ConstructInit(10);
        ConstructInit constructInit02 = new ConstructInit(20);
        System.out.println(constructInit01.value); // 10
        System.out.println(constructInit02.value); // 20

        // final 필드 - 필드 초기화
        System.out.println("필드 초기화");
        FieldInit fieldInit01 = new FieldInit();
        FieldInit fieldInit02 = new FieldInit();
        FieldInit fieldInit03 = new FieldInit();
        System.out.println(fieldInit01.value); // 10
        System.out.println(fieldInit02.value); // 10
        System.out.println(fieldInit03.value); // 10

        // 상수
        System.out.println("상수");
        System.out.println(FieldInit.CONST_VALUE); // static final => 이 두개가 붙은 변수를 상수라고 한다. [관례]

//        Constant.PI;
    }
}

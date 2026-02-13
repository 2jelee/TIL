package access.b;

//import access.a.DefaultClass1;
import access.a.PublicClass;

public class PublicClassOuterMain {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();

        // 다른 패키지 접근 불가 => import하더라도 안됨.
//        DefaultClass1 defaultClass1 = new DefaultClass1();

    }
}

package access.a;

public class AccessData {
    public int publicField;
    int defaultField;
    private int privateField;

    public void publicMethod(){
        System.out.println("publicMethod 호출 : " + publicField);
    }

     void defaultMethod(){
        System.out.println("defaultMethod 호출 : " + defaultField);
    }

    private void privateMethod(){
        System.out.println("privateMethod 호출 : " + privateField);
    }

    // 내부에서는 본인이 있는 모든 필드나 멤버변수에 다 접근 가능.
    public void innerAccess(){
        System.out.println("내부 호출 innerAccess");
        publicField = 100;
        defaultField = 200;
        privateField = 300;
        publicMethod();
        defaultMethod();
        privateMethod();
    }
}

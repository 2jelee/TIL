package poly.diamond;

public class DiamondMain {
    public static void main(String[] args) {
        InterfaceA childA = new Child();
        childA.methodA();
        childA.methodCommon();

        InterfaceB childB = new Child();
        childB.methodB();
        childB.methodCommon();
    }
}

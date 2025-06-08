package static02;

public class DecoMain01 {
    public static void main(String[] args) {
        String str = "Hello java";
        DecoUtil01 utils = new DecoUtil01();
        String deco = utils.deco(str);

        System.out.println("before str : "+ str);
        System.out.println("after str : " + deco);
    }
}

package static01;

public class DataCountMain01 {
    public static void main(String[] args) {
        Data01 data01 = new Data01("A");
        System.out.println("A count = " + data01.count);

        Data01 data02 = new Data01("B");
        System.out.println("B count = " + data02.count);

        Data01 data03 = new Data01("C");
        System.out.println("B count = " + data03.count);
    }
}

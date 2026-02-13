package static01;

public class DataCountMain03 {
    public static void main(String[] args) {
        Data03 data01 = new Data03("A");
        System.out.println("A count = " + Data03.count); // 1 // data01.count가 아닌, Data03.count다.

        Data03 data02 = new Data03("B");
        System.out.println("B count = " + Data03.count); // 2

        Data03 data03 = new Data03("C");
        System.out.println("C count = " + Data03.count); // 3

        // [추가]
        // 인스턴스를 통한 접근
        Data03 data04 = new Data03("D");
        System.out.println(data04.count); // 4

        // 클래스를 통합 접근
        System.out.println(Data03.count); // 4
    }
}

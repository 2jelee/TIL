package poly.ex.pay1;

public class KakaoPay implements Pay {
    private Pay pay;

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    @Override
    public boolean pay(int amount) {
        System.out.println("카카오페이 시스템과 연결합니다.");
        System.out.println(amount + "원 결제를 시도합니다.");
        return true;
    }

    //    public boolean pay(int amount) {
//        System.out.println("카카오페이 시스템과 연결합니다.");
//        System.out.println(amount + "원 결제를 시도합니다.");
//        return true;
//    }
}

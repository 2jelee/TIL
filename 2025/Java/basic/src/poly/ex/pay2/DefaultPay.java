package poly.ex.pay2;

public class DefaultPay implements Pay{
    @Override
    public boolean pay(int amount) {
        System.out.println("결제 수단이 없습니다.");
        return false; // 무조건 항상 false 반환
    }
}

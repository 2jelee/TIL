package poly.ex.pay1;

public class PayService {
    public void processPay(String option, int amount) {
        boolean result = false;
        System.out.println("결제를 시작합니다: option=" + option + ", amount=" + amount);

//        BizType bizType = new BizType();

//        if (option.equals("kakao")) {
//            KakaoPay kakaoPay = new KakaoPay();
//            result = kakaoPay.pay(amount);
//        } else if (option.equals("naver")) {
//            NaverPay naverPay = new NaverPay();
//            result = naverPay.pay(amount);
//        } else {
//            System.out.println("결제 수단이 없습니다.");
//            result = false;
//        }
        Pay[] payArr = new Pay[]{new KakaoPay(), new NaverPay()};

        for (Pay pay : payArr) {
//            pay.setPay(option);
            result = pay.pay(amount);
        }

        if (result) {
        } else {
            System.out.println("결제가 성공했습니다.");
            System.out.println("결제가 실패했습니다.");
        }
    }
}

package poly.ex.pay2;

public class PayService {
    // 변하지 않는 부분
    public void processPay(String option, int amount) {
//        boolean result = false;
        System.out.println("결제를 시작합니다: option=" + option + ", amount=" + amount);
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
//        Pay pay;
//        if (option.equals("kakao")) {
//            pay = new KakaoPay();
//        } else if (option.equals("naver")) {
//            pay = new NaverPay();
//        } else {
//            pay = null;
//            System.out.println("결제 수단이 없습니다.");
//        }
//        Pay pay = findPay(option);
        Pay pay = PayStore.findPay(option);

//        if(pay != null){ // DefaultPay를 생성함으로써 제거
        boolean result = pay.pay(amount);
//        }

        if (result) {
            System.out.println("결제가 성공했습니다.");
        } else {
            System.out.println("결제가 실패했습니다.");
        }
    }

    public Pay findPay(String option){
//        Pay pay;
        if (option.equals("kakao")) {
            return new KakaoPay();
        } else if (option.equals("naver")) {
            return new NaverPay();
        } else {
            System.out.println("결제 수단이 없습니다.");
            return null;
        }
//        return pay;
    }
}

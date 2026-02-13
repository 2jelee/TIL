package ref.ex;

import java.util.Scanner;

/**
 * 문제: 상품 주문 시스템 개발 - 사용자 입력
 * **문제 설명**
 * 앞서 만든 상품 주문 시스템을 사용자 입력을 받도록 개선해보자.
 * **요구 사항**
 * 아래 입력, 출력 예시를 참고해서 다음 사항을 적용하자.
 * 주문 수량을 입력 받자
 * 예) 입력할 주문의 개수를 입력하세요:
 * 가격, 수량, 상품명을 입력 받자
 * 입력시 상품 순서를 알 수 있게 "n번째 주문 정보를 입력하세요." 라는 메시지를 출력하세요.
 * 입력이 끝나면 등록한 상품과 총 결제 금액을 출력하자.
 *
 * [입력, 출력 예시]
 * 입력할 주문의 개수를 입력하세요: 3
 * 1번째 주문 정보를 입력하세요.
 * 상품명: 두부
 * 가격: 2000
 * 수량: 2
 * 2번째 주문 정보를 입력하세요.
 * 상품명: 김치
 * 가격: 5000
 * 수량: 1
 * 3번째 주문 정보를 입력하세요.
 * 상품명: 콜라
 * 가격: 1500
 * 수량: 2
 * 상품명: 두부, 가격: 2000, 수량: 2
 * 상품명: 김치, 가격: 5000, 수량: 1
 * 상품명: 콜라, 가격: 1500, 수량: 2
 * 총 결제 금액: 12000
 */
public class ProductOrderMain3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("입력할 주문의 개수를 입력하세요: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        // 여러 상품의 주문 정보를 담는 배열 생성
        ProductOrder[] productOrder = new ProductOrder[n];
        for (int i = 0; i < productOrder.length; i++) {
            System.out.println((i+1)+"번쨰 주문 정보를 입력하세요. ");
            System.out.print("상품명 : ");
            String productName = scanner.nextLine();
            System.out.print("가격 : ");
            int price = scanner.nextInt();
            System.out.print("수량 : ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // 입력 버퍼를 비우기 위한 코드
            // createOrder()를 여러번 사용해서 상품 주문 정보들을 생성하고 배열에 저장
            productOrder[i] = createOrder(productName,price,quantity);
        }

        // printOrders()를 사용해서 상품 주문 정보 출력
        printOrders(productOrder);

        // getTotalAmount()를 사용해서 총 결제 금액 계산
        // [introduce Variable 단축키] => opt+cmd+v
//        getTotalAmount(productOrder);
        int totalAmount = getTotalAmount(productOrder);
        // 총 결제 금액 출력
        System.out.println("총 결제금액: "+totalAmount);
    }

    static ProductOrder createOrder(String productName, int price, int quantity){
        ProductOrder order = new ProductOrder();
        order.productName = productName;
        order.price = price;
        order.quantity = quantity;
        return order;
    }

    static void printOrders(ProductOrder[] productOrder) {
        for (ProductOrder item : productOrder) {
            System.out.println("상품명: " + item.productName + ", 가격: " + item.price + ", 수량: " + item.quantity);
        }
    }

    //    static void getTotalAmount(ProductOrder[] productOrder) {
//        int totalAmount = 0;
//        for (ProductOrder item : productOrder) {
//            totalAmount += item.price * item.quantity;
//        }
////        return totalAmount;
//        System.out.println("총 결제금액: "+totalAmount);
//    }
    static int getTotalAmount(ProductOrder[] productOrder) {
        int totalAmount = 0;
        for (ProductOrder item : productOrder) {
            totalAmount += item.price * item.quantity;
        }
        return totalAmount;
        //        System.out.println("총 결제금액: "+totalAmount);
    }
}

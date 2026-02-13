package ref.ex;

/**
 * **요구 사항**
 * `ProductOrder` 클래스는 다음과 같은 멤버 변수를 포함해야 한다.
 * 상품명 (`productName` )
 * 가격 (`price` )
 * 주문 수량 (`quantity` )
 *
 * 다음으로 `ref.ex.ProductOrderMain2` 클래스 안에 `main()` 메서드를 포함하여, 여러 상품의 주문 정보를 배열
 * 로 관리하고, 그 정보들을 출력하고, 최종 결제 금액을 계산하여 출력하자. 이 클래스에서는 다음과 같은 메서드를 포함
 * 해야 합니다:
 * `static ProductOrder createOrder(String productName, int price, int quantity)`
 * `ProductOrder` 를 생성하고 매개변수로 초기값을 설정합니다. 마지막으로 생성한 `ProductOrder` 를
 * 반환합니다.
 * `static void printOrders(ProductOrder[] orders)`
 * 배열을 받아서 배열에 들어있는 전체 `ProductOrder` 의 상품명, 가격, 수량을 출력합니다.
 * `static int getTotalAmount(ProductOrder[] orders)`
 * 배열을 받아서 배열에 들어있는 전체 `ProductOrder` 의 총 결제 금액을 계산하고, 계산 결과를 반환합니다.
 *
 * **출력 예시**
 * 상품명: 두부, 가격: 2000, 수량: 2
 * 상품명: 김치, 가격: 5000, 수량: 1
 * 상품명: 콜라, 가격: 1500, 수량: 2
 * 총 결제 금액: 12000
 */
public class ProductOrderMain2 {
    public static void main(String[] args) {
        // 여러 상품의 주문 정보를 담는 배열 생성
        ProductOrder[] productOrder = new ProductOrder[3];
        // createOrder()를 여러번 사용해서 상품 주문 정보들을 생성하고 배열에 저장
        productOrder[0] = createOrder("두부", 2000, 2);
        productOrder[1] = createOrder("김치", 5000, 1);
        productOrder[2] = createOrder("콜라", 1500, 2);

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



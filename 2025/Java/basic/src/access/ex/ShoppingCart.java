package access.ex;
public class ShoppingCart {
    private Item[] items = new Item[10];
    private int itemCount;

    //TODO 나머지 코드를 완성해라.
    public void addItem(Item item){
        // 추가
        // 검증 로직
        if(itemCount >= items.length){
            System.out.println("장바구니가 가득 찼습니다.");
            return;
        }
        // 정상 로직
        items[itemCount] = item;
        itemCount++;
    }

    /**
     * 장바구니 상품 출력
     * 상품명:마늘, 합계:4000
     * 상품명:상추, 합계:12000
     * 전체 가격 합:16000
     */
    // 추가
    public void displayItems(){
        System.out.println("장바구니 상품 출력");
        for (int i = 0; i < itemCount; i++) {
            Item item = items[i];
            System.out.println("상품명 : " + item.getName() + ", 합계 : "+item.getTotalPrice());
        }
        System.out.println("전체 가격 합 : "+calculateToTalPrice());
    }

    // 추가
    // `calculateTotalPrice()` : 이 메서드 내부에서만 사용되므로 `private` 접근 제어자를 사용한다.
    private int calculateToTalPrice(){
        int totalPrice = 0;
        for (int i = 0; i < itemCount; i++) {
            Item item = items[i];
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }
}

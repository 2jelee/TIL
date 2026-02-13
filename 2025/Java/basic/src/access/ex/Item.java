package access.ex;

public class Item {
    private String name;
    private int price;
    private int quantity;

    public Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // 추가
    public String getName(){
        return name;
    }

    // 추가 => 객체지향
    public int getTotalPrice(){
        return price * quantity;
    }
}

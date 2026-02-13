package access;

public class BankAccount {
    private int balance;

    // cmd+N
    public BankAccount() {
        balance = 0;
    }

    // public method
    public void deposit(int amount){
        if(isAmountValid(amount)){
            balance += amount;
        } else {
            System.out.println("유효하지 않은 금액입니다.");
        }
    }

    // 금액 검증 로직 => private 해당 클래스에서만 사용되므로.
    // `isAmountValid()` : 입력 금액을 검증하는 기능은 내부에서만 필요한 기능이다. 따라서 `private` 을 사용했다.
    private boolean isAmountValid(int amount){
//    public boolean isAmountValid(int amount){

        // 금액이 0보다 커야 함.
        return amount > 0;
    }

    public void withdraw(int amount){
        if(isAmountValid(amount) && balance - amount > 0){
            balance -= amount;
        } else {
            System.out.println("유효하지 않은 금액이거나 잔액이 부족합니다.");
        }
    }

    public int getBalance(){
        return balance;
    }
}

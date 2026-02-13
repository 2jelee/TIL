package oop.ex;

public class Account {
    int balance = 0;

    // 입금 메서드 - 입금시 잔액이 증가한다.
    void deposit(int amount){
        this.balance += amount;
    }

    // 출금 메서드 - 출금시 잔액이 감소한다. 만약 잔액이 부족하면 "잔액 부족"을 출력.
    void withdraw(int amount){
        if(balance <= amount){
            System.out.println("잔액 부족");
        } else{
            this.balance -= amount;
        }
    }
}

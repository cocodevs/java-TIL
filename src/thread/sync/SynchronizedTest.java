package thread.sync;

import static java.lang.Thread.sleep;

class MoneyController {
    private int money = 50000;
    public void plusMoney(int money){
        int nowMoney = getMoney();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setMoney(nowMoney + money);
    }
    public void minusMoney(int money){
        int nowMoney = getMoney();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setMoney(nowMoney - money);
    }
    public int getMoney(){
        return money;
    }
    public void setMoney(int money){
        this.money = money;
    }
}

class ThreadA extends Thread{
    public void run() {
        SynchronizedTest.moneyController.plusMoney(20000);
        System.out.println(SynchronizedTest.moneyController.getMoney());
    }
}

class ThreadB extends Thread{
    public void run() {
        SynchronizedTest.moneyController.minusMoney(30000);
        System.out.println(SynchronizedTest.moneyController.getMoney());
    }
}

public class SynchronizedTest{

    public static MoneyController moneyController = new MoneyController();
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start();
        threadB.start();
    }
}

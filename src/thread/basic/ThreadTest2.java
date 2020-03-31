package thread.basic;

import static java.lang.Thread.sleep;

class MyThread2 implements Runnable {

    public void run(){
        for(int i=0; i<=200; i++){
            System.out.print(i + "\t");

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ThreadTest2 {
    public static void main(String[] args) {

        System.out.println("== start ==");
        MyThread2 runner1 = new MyThread2();
        Thread th1 = new Thread(runner1);
        th1.start();

        MyThread2 runner2 = new MyThread2();
        Thread th2 = new Thread(runner2);
        th2.start();

        System.out.println("== end ==");

    }
}

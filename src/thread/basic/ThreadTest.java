package thread.basic;

class MyThread1 extends Thread {

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

public class ThreadTest {
    public static void main(String[] args) {

        System.out.println("== start ==");
        MyThread1 th1 = new MyThread1();
        MyThread1 th2 = new MyThread1();

        th1.start();
        th2.start();

        System.out.println("== end ==");

    }
}

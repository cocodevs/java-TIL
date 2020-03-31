package thread.interrupt;

public class InterruptTest2 extends Thread {
    public void run(){
        try {
            while (true){
                System.out.println("호출");
                sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
            System.out.println("Wake!!");
        }
    }

    public static void main(String[] args){
        InterruptTest2 test = new InterruptTest2();
        test.start();

        try {
            test.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        test.interrupt();
        System.out.println("end");
    }
}

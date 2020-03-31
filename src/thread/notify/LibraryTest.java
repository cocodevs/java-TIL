package thread.notify;

import java.util.ArrayList;
import java.util.List;

class FastLibrary{

    public List<String> books = new ArrayList<>();

    public FastLibrary(){
        books.add("책 1");
        books.add("책 2");
        books.add("책 3");
        /*books.add("책 4");
        books.add("책 5");
        books.add("책 6");*/
    }

    public synchronized String lendBook() throws InterruptedException {

        Thread t = Thread.currentThread();

        while( books.size() == 0 ){
            System.out.println(t.getName() + "waiting start");
            wait();
            System.out.println(t.getName() + "waiting end");
        }
        String title = books.remove(0);

        System.out.println(t.getName() + " : " + title + " lend");
        return title;
    }

    public synchronized void returnBook(String title){
        Thread t = Thread.currentThread();
        books.add(title);
        //notify();
        notifyAll();
        System.out.println(t.getName() + " : " + title + " return");
    }
}

class Student extends Thread{
    public void run() {
        try {
            String title = LibraryTest.library.lendBook();
            if( title == null ){
                return;
            }
            sleep(5000);
            LibraryTest.library.returnBook(title);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class LibraryTest {

    public static FastLibrary library = new FastLibrary();
    public static void main(String[] args){
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        Student s4 = new Student();
        Student s5 = new Student();
        Student s6 = new Student();

        s1.start();
        s2.start();
        s3.start();
        s4.start();
        s5.start();
        s6.start();

    }
}


// Q1. Create and Run a Thread using Runnable Interface and Thread class.

import java.util.stream.IntStream;

class multiThread extends Thread{

    public void run(){

        IntStream.rangeClosed(1,10).forEach(x -> { System.out.println("Thread: " +x );
            try {
                multiThread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}

class Runner implements Runnable {

    public void run() {
        IntStream.rangeClosed(10, 20).forEach(x -> {
            System.out.println("Runnable: "+x);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}




public class Q1 {
    public static void main(String[] args) {

        //Using thread class
        multiThread t1 = new multiThread();
        t1.start();

        //Using Runnable interface
        Thread r1 = new Thread(new Runner());
        r1.start();


    }
}
/*

Output:
        Runnable: 10
        Thread: 1
        Runnable: 11
        Thread: 2
        Thread: 3
        Runnable: 12
        Thread: 4
        Runnable: 13
        Thread: 5
        Runnable: 14
        Thread: 6
        Runnable: 15
        Thread: 7
        Runnable: 16
        Thread: 8
        Runnable: 17
        Thread: 9
        Runnable: 18
        Thread: 10
        Runnable: 19
        Runnable: 20
*/

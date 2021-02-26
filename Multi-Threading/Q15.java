
//Q.15 Use ReentrantLock to coordinate two threads with signal(), signalAll(), and wait()

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Q15 {

    Lock myReentrantLock = new ReentrantLock(true);
    Condition condition = myReentrantLock.newCondition();

    public void methodOne() {
        try {
            myReentrantLock.lock();
            System.out.println("Method 1 Started");
            condition.await();
            System.out.println("Method 1 Finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            myReentrantLock.unlock();
        }
    }

    public void methodTwo(){
        try {
            myReentrantLock.lock();
            System.out.println("Method 3 Started");
            System.out.println("Method 3 Finished");
            condition.signal();
        }  finally {
            myReentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Q15 q15obj = new Q15();

        System.out.println("Thread starting: " + Thread.currentThread().getName());

        Thread thread1 = new Thread(q15obj::methodOne);
        Thread thread2 = new Thread(q15obj::methodTwo);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Thread exiting: " + Thread.currentThread().getName());
    }
}

/*
Output:
        Thread starting: main
        Method 1 Started
        Method 3 Started
        Method 3 Finished
        Method 1 Finished
        Thread exiting: main
*/

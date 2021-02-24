
//Q.15 Use ReentrantLock to coordinate two threads with signal(), signalAll(), and wait()

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Q15 {

    Lock lock = new ReentrantLock(true);
    Condition condition = lock.newCondition();

    public void methodOne() {
        try {
            lock.lock();
            System.out.println("Method 1 Started");
            condition.await();
            System.out.println("Method 1 Finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void methodTwo(){
        try {
            lock.lock();
            System.out.println("Method 3 Started");
            System.out.println("Method 3 Finished");
            condition.signal();
        }  finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Q15 obj = new Q15();

        System.out.println("Thread starting: " + Thread.currentThread().getName());

        Thread thread1 = new Thread(obj::methodOne);
        Thread thread2 = new Thread(obj::methodTwo);

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

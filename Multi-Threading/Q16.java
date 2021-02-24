
//Q.16 Create a deadlock and Resolve it using tryLock().

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Q16 {
    Lock lock1 = new ReentrantLock(true);
    Lock lock2 = new ReentrantLock(true);

    public int acquireLock(Lock lock1, Lock lock2) {
        boolean acquireLock1 = lock1.tryLock();
        boolean acquireLock2 = lock2.tryLock();

        if (acquireLock1 && acquireLock2) {
            return 1;
        }

        if (acquireLock1) {
            lock1.unlock();
        }

        if (acquireLock2) {
            lock2.unlock();
        }
        return 0;

    }

    public void method1() {
        if (acquireLock(lock1, lock2) == 1) {
            System.out.println("Method 1 Lock 1");
            System.out.println("Method 1 Lock 2 ");
            lock2.unlock();
            lock1.unlock();
        } else
            System.out.println("Method2 lock not acquired ");
    }

    public void method2() {
        if (acquireLock(lock2, lock1) == 1) {
            System.out.println("Method 2 Lock 1 ");
            System.out.println("Method 2 Lock 2 ");
            lock1.unlock();
            lock2.unlock();
        } else
            System.out.println("Method2 lock not acquired ");

    }

    public static void main(String[] args) throws InterruptedException {

        Q16 deadlock = new Q16();

        Thread thread1 = new Thread(deadlock::method1);

        Thread thread2 = new Thread(deadlock::method2);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}

/*
Output:
        Method 1 Lock 1
        Method 1 Lock 2
        Method 2 Lock 1
        Method 2 Lock 2
*/

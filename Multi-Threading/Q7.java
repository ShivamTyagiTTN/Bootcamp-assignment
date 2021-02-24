//Q.7 Submit List of tasks to ExecutorService and wait for the completion of all the tasks.

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MyThread implements Runnable{
    private static int count=0;

    public void run() {
        System.out.println("Thread :  "+ ++count);
    }
}

public class Q7 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();

        ExecutorService executors = Executors.newSingleThreadExecutor();
        executors.submit(t1);
        executors.submit(t2);
        executors.submit(t3);
        executors.submit(t4);

        executors.shutdown();

        executors.awaitTermination(1, TimeUnit.MINUTES);

        if (executors.isTerminated()) {
            System.out.println("Terminated");
        } else {
            System.out.println("Still in execution");
        }
    }
}

/*
Output:

        Thread :  1
        Thread :  2
        Thread :  3
        Thread :  4
        Terminated
*/

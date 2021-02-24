
//Q3 Use a singleThreadExecutor to submit multiple threads.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();


        executorService.submit(new Runnable() {
            public void run() {
                System.out.println("Thread 1");
            }
        });

        executorService.submit(new Runnable() {
            public void run() {
                System.out.println("Thread 2");
            }
        });

        executorService.submit(new Runnable() {
            public void run() {
                System.out.println("Thread 3");
            }
        });

    }
}

/*
Output:
        Thread 1
        Thread 2
        Thread 3
*/

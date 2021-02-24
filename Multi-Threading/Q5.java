
//Q.5 Use isShutDown() and isTerminated() with ExecutorService.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q5 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.submit(() -> System.out.println("Thread1 running"));

        executorService.submit(() -> System.out.println("Thread2 running"));

        executorService.shutdown();

        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());
    }
}

/*
Output:
        Thread1 running
        true
        false
        Thread2 running
*/

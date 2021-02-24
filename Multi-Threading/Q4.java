
//Q.4 Try shutdown() and shutdownNow() and observe the difference.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q4 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

            executorService.submit(() -> System.out.println("Thread 1"));

            executorService.submit(() -> System.out.println("Thread 2"));

            executorService.submit(() -> System.out.println("Thread 3"));


            executorService.shutdown();

            //executorService.shutdownNow();
    }
}

/*
Output with shutdown():

        Thread 1
        Thread 2
        Thread 3

Output with shutdownNow():

        Thread 1


It is observed that with shutdownNow() executorService shuts down even if all the thread are not executed.
while shutdown() only shuts down when all the threads have finished execution.
*/

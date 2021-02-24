
//Q.6 Return a Future from ExecutorService by using callable and use get(), isDone(), isCancelled() with the Future
// object to know the status of task submitted.

import java.util.concurrent.*;

public class Q6 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> futureStr = executorService.submit(new Callable<>() {

            public String call() throws Exception {
                return "Finished";
            }
        });

        executorService.shutdown();
        System.out.println("IsTerminated: " + executorService.isTerminated());

        if (futureStr.isCancelled()) {
            System.out.println("Your task has been cancelled");
        }

        System.out.println("IsDone: " + futureStr.isDone());

        if (futureStr.isDone()) {
            System.out.println(futureStr.get());

        }
    }
}

/*
Output:

        IsTerminated: false
        IsDone: true
        Finished
*/


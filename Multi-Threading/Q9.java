
//Q.9 Increase concurrency with Thread pools using newCachedThreadPool() and newFixedThreadPool().

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Q9{
    public static void main(String[] args) {

        //ExecutorService executorService= Executors.newCachedThreadPool();

        ExecutorService executorService= Executors.newFixedThreadPool(3);

        for (int i = 0; i <= 5; i++) {

            int finalI = i;
            executorService.submit(new Runnable() {

                public void run() {

                    System.out.println(Thread.currentThread().getName() + " Start :" + finalI);

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + " End :" + finalI);
                }
            });
        }
        executorService.shutdown();
    }
}

/*
Output using newCachedThreadPool():
        pool-1-thread-4 Start :3
        pool-1-thread-2 Start :1
        pool-1-thread-1 Start :0
        pool-1-thread-3 Start :2
        pool-1-thread-5 Start :4
        pool-1-thread-6 Start :5
        pool-1-thread-1 End :0
        pool-1-thread-4 End :3
        pool-1-thread-3 End :2
        pool-1-thread-5 End :4
        pool-1-thread-6 End :5
        pool-1-thread-2 End :1

Output using newFixedThreadPool(3):
        pool-1-thread-1 Start :0
        pool-1-thread-3 Start :2
        pool-1-thread-2 Start :1
        pool-1-thread-1 End :0
        pool-1-thread-3 End :2
        pool-1-thread-2 End :1
        pool-1-thread-3 Start :3
        pool-1-thread-2 Start :4
        pool-1-thread-1 Start :5
        pool-1-thread-3 End :3
        pool-1-thread-2 End :4
        pool-1-thread-1 End :5
*/



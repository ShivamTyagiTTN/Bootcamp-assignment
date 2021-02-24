
//Q.2 Use sleep and join methods with thread.

public class Q2 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            try {
                for(int i=0;i<5;i++) {
                    Thread.sleep(100);
                    System.out.println("Thread1 "+i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread thread2 = new Thread(() -> {
            try {
                for(int i=0;i<5;i++) {
                    Thread.sleep(100);
                    System.out.println("Thread2 "+i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Finished Execution");

    }
}

/*
Output:

        Thread1 0
        Thread2 0
        Thread1 1
        Thread2 1
        Thread1 2
        Thread2 2
        Thread1 3
        Thread2 3
        Thread2 4
        Thread1 4
        Finished Execution
*/

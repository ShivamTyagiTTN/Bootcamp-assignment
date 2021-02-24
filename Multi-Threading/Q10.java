
//Q.10 Use Synchronize method to enable synchronization between multiple threads trying to access method at same time.

class Q10 {

    private int count =0;

    public synchronized void increment(){
        count++;
    }

    public void doWork() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count: "+count);
    }

    public static void main(String[] args) throws InterruptedException {
        Q10 obj = new Q10();
        obj.doWork();
    }
}

/*
Output:
        Count: 20000
*/

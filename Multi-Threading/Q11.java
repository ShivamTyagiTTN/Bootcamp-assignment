
//Q.11 Use Synchronize block to enable synchronization between multiple threads trying to access method at same time.

import java.util.ArrayList;
import java.util.Random;

public class Q11 {

    private final Object list1 = new Object();
    private final Object list2 = new Object();

    private final Random random = new Random();

    private final ArrayList<Integer> l1 = new ArrayList<>();
    private final ArrayList<Integer> l2 = new ArrayList<>();

    public void stageOne(){

        synchronized(list1){
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                l1.add(random.nextInt());
            }
        }
    }

    public void stageTwo(){
        synchronized(list2){
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                l2.add(random.nextInt());
            }
        }
    }
    void process(){

        stageOne();
        stageTwo();
    }

    public static void main(String[] args) throws InterruptedException {

        Q11 obj = new Q11();

        Thread t1 = new Thread(obj::process);
        Thread t2 = new Thread(obj::process);

        long start = System.currentTimeMillis();
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Time taken: " + (System.currentTimeMillis()-start));
        System.out.println("List1 size: "+obj.l1.size() + " List2 size: " + obj.l2.size());
    }
}
/*

Output:
    Time taken: 3102
    List1 size: 2000 List2 size: 2000
*/

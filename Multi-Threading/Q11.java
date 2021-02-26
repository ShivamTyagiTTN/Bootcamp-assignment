
//Q.11 Use Synchronize block to enable synchronization between multiple threads trying to access method at same time.

import java.util.ArrayList;
import java.util.Random;

public class Q11 {

    private final Object obj1 = new Object();
    private final Object obj2 = new Object();

    private final Random random = new Random();

    private final ArrayList<Integer> integerList1 = new ArrayList<>();
    private final ArrayList<Integer> integerList2 = new ArrayList<>();

    public void stageOne(){

        synchronized(obj1){
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                integerList1.add(random.nextInt());
            }
        }
    }

    public void stageTwo(){
        synchronized(obj2){
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                integerList2.add(random.nextInt());
            }
        }
    }
    void process(){

        stageOne();
        stageTwo();
    }

    public static void main(String[] args) throws InterruptedException {

        Q11 q11obj = new Q11();

        Thread thread1 = new Thread(q11obj::process);
        Thread thread2 = new Thread(q11obj::process);

        long start = System.currentTimeMillis();
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Time taken: " + (System.currentTimeMillis()-start));
        System.out.println("List1 size: "+q11obj.integerList1.size() + "  List2 size: " + q11obj.integerList2.size());
    }
}
/*

Output:
    Time taken: 3102
    List1 size: 2000  List2 size: 2000
*/

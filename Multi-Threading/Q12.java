
//Q.12 Use Atomic Classes instead of Synchronize method and blocks.

import java.util.concurrent.atomic.AtomicInteger;

class NewAtomicClass {
    AtomicInteger count =new AtomicInteger();


    public void stageOne(){
        for(int i=0;i<1000;i++) {
            count.incrementAndGet();
        }
    }

    public void stageTwo(){
        for(int i=0;i<1000;i++) {
            count.incrementAndGet();
        }
    }
}

class Q12{

    public static void main(String[] args) throws InterruptedException {

        NewAtomicClass newAtomicObj = new NewAtomicClass();

        Thread thread1 = new Thread(newAtomicObj::stageOne);

        Thread thread2 = new Thread(newAtomicObj::stageTwo);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Count: "+newAtomicObj.count);
    }
}

/*
Output:
        Count: 2000
*/

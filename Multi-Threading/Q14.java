
//Q.14 Coordinate multiple threads using wait() and notifyAll()

class WaitAndNotifyAll {

    public void method1()throws Exception{
        synchronized (this){
            System.out.println("Method 1 Started ");
            wait();
            System.out.println("Method 1 Ended ");
        }
    }
    public void method2() throws Exception {
        synchronized (this) {
            System.out.println("Method 2 Started ");
            wait();
            System.out.println("Method 2 Ended ");
        }
    }

    public void method3(){
        synchronized (this){
            System.out.println("Method 3 Started ");
            System.out.println("Method 3 Ended ");
            notifyAll();

        }
    }
}

class Q14{
    public static void main(String[] args) {

        WaitAndNotifyAll obj = new WaitAndNotifyAll();

        Thread thread1 = new Thread(() -> {
            try {
                obj.method1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            try {
                obj.method2();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread2.start();

        Thread thread3 = new Thread(obj::method3);
        thread3.start();
    }
}

/*
Output:
        Method 1 Started
        Method 2 Started
        Method 3 Started
        Method 3 Ended
        Method 1 Ended
        Method 2 Ended
*/

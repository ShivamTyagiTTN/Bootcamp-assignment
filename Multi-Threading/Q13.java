
//Q13 Coordinate 2 threads using wait() and notify()


class WaitAndNotify {

    public void method1()throws Exception{
        synchronized (this){
            System.out.println("Method 1 Started ");
            wait();
            System.out.println("Method 1 Ended ");
        }
    }

    public void method2(){
        synchronized (this){
            System.out.println("Method 2 Started ");
            System.out.println("Method 2 Ended ");
            notify();

        }
    }
}

class Q13{
    public static void main(String[] args) {

        WaitAndNotify obj = new WaitAndNotify();

        Thread thread1 = new Thread(() -> {
            try {
                obj.method1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(obj::method2);
        thread2.start();
    }
}

/*
Output:
        Method 1 Started
        Method 2 Started
        Method 2 Ended
        Method 1 Ended
*/

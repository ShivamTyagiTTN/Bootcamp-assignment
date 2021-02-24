/*
 * Schedule task using schedule(), scheduleAtFixedRate() and scheduleAtFixedDelay()
 * */


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Q8 {

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();

        scheduledExecutor.schedule(new Runnable() {

            public void run() {
                System.out.println("Schedule Task executed");
            }
        }, 2, TimeUnit.SECONDS);


        scheduledExecutor.scheduleAtFixedRate(new Runnable() {

            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("ScheduleAtFixedRate");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1, TimeUnit.SECONDS);


        scheduledExecutor.scheduleWithFixedDelay(new Runnable() {

            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("ScheduleWithFixedDelay");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}
/*

Output:
        ScheduleAtFixedRate
        ScheduleWithFixedDelay
        ScheduleAtFixedRate
        Schedule Task executed
        ScheduleAtFixedRate
        ScheduleAtFixedRate
        ScheduleWithFixedDelay
        ScheduleAtFixedRate
        ScheduleAtFixedRate
        .
        .
        .

*/

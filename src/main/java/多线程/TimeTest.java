package 多线程;

import java.util.Timer;
import java.util.TimerTask;

public class TimeTest {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            int count = 0;

            @Override
            public void run() {
                count++;
                System.out.println("Task executed " + count + " times");
                if (count == 5) {
                    timer.cancel();  // 停止Timer上的所有调度任务
                    System.out.println("Timer cancelled");
                }
            }
        }, 0, 1000);  // 任务每隔1秒执行一次

        // Main thread sleeps for a while to let the timer tasks execute
        Thread.sleep(10000);
    }
}

package 多线程;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTest {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                LocalDateTime now = LocalDateTime.now();
                System.out.println("线程开始运行时间：" + dateTimeFormatter.format(now));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Runnable task executed");
            }
        };

        FutureTask<String> futureTask = new FutureTask<>(runnable, "Task Completed");

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(futureTask);

        try {
            LocalDateTime now = LocalDateTime.now();
            System.out.println("开始获取结果" + dateTimeFormatter.format(now));
            String result = futureTask.get();  // 返回"Task Completed"
            LocalDateTime now1 = LocalDateTime.now();
            System.out.println("获取结果后" + dateTimeFormatter.format(now1));
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}

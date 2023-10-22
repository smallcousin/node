package 多线程;

import java.util.concurrent.*;

public class CallableAndFuture {
    public static void main(String[] args) {
        // 创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

// 创建一个Callable任务
        Callable<String> callableTask = new Callable<String>() {
            @Override
            public String call() throws Exception {
                // 模拟长时间任务
                Thread.sleep(1000);
                return "Task completed";
            }
        };

// 提交任务并获取Future
        Future<String> future = executorService.submit(callableTask);

        try {
            // 获取并打印任务结果，如果任务还没完成就等待
            String result = future.get();
            System.out.println("Future得到的结果是：" + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

// 关闭线程池
        executorService.shutdown();
    }
}

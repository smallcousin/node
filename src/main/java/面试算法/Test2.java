package 面试算法;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class Test2 {
    public static void main(String[] args) {
        AtomicInteger temp = new AtomicInteger();
        Thread thread1 = new Thread(() -> {
            while (true) {
                if (temp.get() % 2 == 1) {
                    System.out.println(temp.get() + "--------------");
                    temp.getAndIncrement();
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            while (true) {
                if (temp.get() % 2 == 0) {
                    System.out.println(temp.get() + "++++++++++++++");
                    temp.getAndIncrement();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}

package 多线程;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class WorkerTest implements Runnable{
    private final CyclicBarrier barrier;

    WorkerTest(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " wait前");
            // do part 1
            barrier.await(); // wait for others
            System.out.println(Thread.currentThread().getName() + " wait后");
            // do part 2
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        new Thread(new WorkerTest(barrier), "1").start();
        new Thread(new WorkerTest(barrier), "2").start();
        new Thread(new WorkerTest(barrier), "3").start();
    }
}

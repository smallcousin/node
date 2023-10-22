package 多线程;

public class Wait {
    public static void main(String[] args) {
        final Object lock = new Object();

        Thread waitingThread = new Thread(() -> {
            System.out.println("Waiting thread is about to enter synchronized block...");
            synchronized (lock) {
                try {
                    System.out.println("Waiting thread has entered synchronized block and will wait...");
                    lock.wait();
                    System.out.println("Waiting thread has been notified and resumed execution...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread notifyingThread = new Thread(() -> {
            System.out.println("Notifying thread is about to enter synchronized block...");
            synchronized (lock) {
                System.out.println("Notifying thread has entered synchronized block and will notify...");
                lock.notify();
                System.out.println("Notifying thread has notified and finished execution...");
            }
        });

        waitingThread.start();
        try {
            Thread.sleep(1000); // This sleep ensures that waitingThread starts first
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyingThread.start();
    }
}

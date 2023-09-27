package 设计模式.单例.懒汉式.线程不安全;


public class Client {
    public static void main(String[] args) {
        //证实线程不安全
//        final Singleton[] instance = new Singleton[1];
//        final Singleton[] instance1 = new Singleton[1];
//        Thread thread = new Thread(() -> {
//            try {
//                instance[0] = Singleton.getInstance();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        Thread thread1 = new Thread(() -> {
//            try {
//                instance1[0] = Singleton.getInstance();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        thread.start();
//        thread1.start();
//        try {
//            thread.join();
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(instance[0] == instance1[0]);
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }
}

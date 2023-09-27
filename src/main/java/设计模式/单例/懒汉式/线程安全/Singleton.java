package 设计模式.单例.懒汉式.线程安全;

public class Singleton {
    private Singleton() {
    }
    private static Singleton instance;
    public static synchronized Singleton getInstance() throws InterruptedException {
        if (instance == null) {
            Thread.sleep(1000);
            instance = new Singleton();
        }
        return instance;
    }
}

package 设计模式.单例.懒汉式.双重检查锁模式;

public class Singleton {
    private Singleton() {
    }
    private static volatile Singleton instance;
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

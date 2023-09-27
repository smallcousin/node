package 设计模式.单例.懒汉式.线程不安全;

public class Singleton {
    private Singleton() {
    }
    private static Singleton singleton;
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

package 设计模式.单例.懒汉式.静态内部类方式;

//静态内部类方式是比较优秀的单例模式
public class Singleton {
    private Singleton() {
    }
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

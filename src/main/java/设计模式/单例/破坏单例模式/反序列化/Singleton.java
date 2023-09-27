package 设计模式.单例.破坏单例模式.反序列化;

import java.io.Serializable;

public class Singleton implements Serializable {
    public Singleton() {
    }
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
    private Object readResolve() {
        return SingletonHolder.INSTANCE;
    }
}

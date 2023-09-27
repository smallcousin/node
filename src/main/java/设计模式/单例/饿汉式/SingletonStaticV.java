package 设计模式.单例.饿汉式;


/**
 * 懒汉式--静态变量
 */
public class SingletonStaticV {
    private static SingletonStaticV instance = new SingletonStaticV();

    private SingletonStaticV() {
    }

    public static SingletonStaticV getInstance() {
        return instance;
    }
}

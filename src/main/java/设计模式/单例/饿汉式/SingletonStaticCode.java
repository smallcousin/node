package 设计模式.单例.饿汉式;


/**
 * 饿汉式--静态代码块
 */
public class SingletonStaticCode {
    private static SingletonStaticCode instance;
    static {
        instance = new SingletonStaticCode();
    }

    private SingletonStaticCode() {
    }
    public static SingletonStaticCode getInstance() {
        return instance;
    }
}

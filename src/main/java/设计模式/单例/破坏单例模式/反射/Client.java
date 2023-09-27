package 设计模式.单例.破坏单例模式.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Client {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Constructor<Singleton> declaredConstructor = Singleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Singleton singleton = declaredConstructor.newInstance();
        Singleton singleton1 = declaredConstructor.newInstance();
        System.out.println(singleton1 == singleton);
    }
}

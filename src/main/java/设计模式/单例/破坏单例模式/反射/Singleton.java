package 设计模式.单例.破坏单例模式.反射;

public class Singleton {
    private static boolean flag = false;
    private Singleton() {
        synchronized (Singleton.class) {

            //判断flag的值是否是true，如果是true，说明非第一次访问，直接抛一个异常，如果是false的话，说明第一次访问
            if (flag) {
//                throw new RuntimeException("不能创建多个对象");
                System.out.println("创建了多个对象");
            }
            //将flag的值设置为true
            flag = true;
        }
    }
    private static Singleton instance;
    public static Singleton getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (Singleton.class) {
            if (instance != null) {
                return instance;
            }
            instance = new Singleton();
            return instance;
        }
    }
}

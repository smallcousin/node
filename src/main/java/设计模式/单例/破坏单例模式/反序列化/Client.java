package 设计模式.单例.破坏单例模式.反序列化;

import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
//        object2File();
        Singleton singleton = readObjectFromFile();
        Singleton singleton1 = readObjectFromFile();
        System.out.println(singleton.toString());
        System.out.println(singleton1.toString());
        System.out.println(singleton1 == singleton);
    }
    public static Singleton readObjectFromFile() throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new
                FileInputStream("D:\\z\\ab.txt"));
        Singleton singleton;
        try {
            singleton = (Singleton)objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return singleton;
    }
    public static void object2File() throws IOException {
        Singleton instance = Singleton.getInstance();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\z\\ab.txt"));
        objectOutputStream.writeObject(instance);
    }
}

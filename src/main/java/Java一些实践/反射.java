package Java一些实践;

public class 反射 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class catClass = Class.forName("Java一些实践.Cat");
        System.out.println(catClass.isAnnotation());
        System.out.println(catClass.isEnum());
        System.out.println(catClass.isPrimitive());
    }
}

class Cat {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

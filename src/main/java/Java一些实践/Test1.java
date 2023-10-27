package Java一些实践;

public class Test1 {
    public final char value[];

    public Test1(char[] value) {
        this.value = value;
    }

    public static void main(String[] args) {
        char[] chars = "aaa".toCharArray();
        Test1 aaa = new Test1(chars);
        chars[0] = 'b';
        System.out.println(aaa.value);
    }
}

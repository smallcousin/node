package 面试算法;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int ans = n % 3;
            if (ans == 0) ans = 3;
            if (n <= 0) System.out.println("出错了");
            else System.out.println(ans);
        }
    }
}

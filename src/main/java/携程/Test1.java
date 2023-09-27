package 携程;

import java.util.HashMap;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        int temp = n;
        if (k * 3 > n) {
            System.out.println(-1);
            return ;
        }
        while (k-- > 0) {
            sb.append("you");
        }
        for (int i = 0; i < n - 3 * k; i++) {
            if (i % 3 == 0) {
                sb.append('u');
            } else if (i % 3 == 1) {
                sb.append('o');
            } else {
                sb.append('y');
            }
        }
        System.out.println(sb);
    }
}


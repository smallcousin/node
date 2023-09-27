package 携程;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long ans = (n - 1) / 3 * 2;
        if (n % 3 == 0) ans /= 2;
        System.out.println(ans);
    }
    public static long getAns(long n, long store) {
        if (n == 1) {
            return (store - 1) % 3 == 0 ? 1 : 0;
        }
        long ans = 0;
        if (n % 2 == 0) {
            ans = getAns(n / 2, store) * 2;
        } else {
            ans = getAns(n / 2 + 1, store) * 2 - 1;
        }
        return ans;
    }
}

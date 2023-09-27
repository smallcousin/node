package 面试算法;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Test {
    private static final LocalTime LUNCH_START = LocalTime.of(12, 0);
    private static final LocalTime LUNCH_END = LocalTime.of(14, 0);
    private static final LocalTime DINNER_START = LocalTime.of(18, 0);
    private static final LocalTime DINNER_END = LocalTime.of(19, 30);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 读取进门禁的次数
        scanner.nextLine();
        LocalTime[] inTimes = new LocalTime[n];
        for (int i = 0; i < n; i++) {
            inTimes[i] = LocalTime.parse(scanner.next()); // 读取每次进门禁的时间
        }
        int m = scanner.nextInt(); // 读取出门禁的次数
        scanner.nextLine();
        LocalTime[] outTimes = new LocalTime[m];
        for (int i = 0; i < m; i++) {
            outTimes[i] = LocalTime.parse(scanner.next()); // 读取每次出门禁的时间
        }

        long totalMinutes = 0;
        for (int i = 0; i < n; i++) {
            long minutes = ChronoUnit.MINUTES.between(inTimes[i], outTimes[i]);
            if (minutes > 15) { // 如果离岗超过15分钟，才从工作时长中扣除
                if (inTimes[i].isBefore(LUNCH_START) && outTimes[i].isAfter(LUNCH_START)) {
                    minutes -= ChronoUnit.MINUTES.between(LUNCH_START, outTimes[i].isBefore(LUNCH_END) ? outTimes[i] : LUNCH_END);
                }
                if (inTimes[i].isBefore(DINNER_START) && outTimes[i].isAfter(DINNER_START)) {
                    minutes -= ChronoUnit.MINUTES.between(DINNER_START, outTimes[i].isBefore(DINNER_END) ? outTimes[i] : DINNER_END);
                }
                totalMinutes += minutes;
            }
        }
        System.out.println(totalMinutes); // 输出当日的工作时长
    }
}

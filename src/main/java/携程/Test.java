package 携程;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int i = equalPairs(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 4}, {2, 4, 2, 2}, {2, 5, 2, 2}});
        System.out.println(i);
    }
    public static int equalPairs(int[][] grid) {
        int ans = 0;
        Set<List<Integer>> sets = new HashSet<>();
        Map<List<Integer>, Integer> maps = new HashMap<>();
        for (int i = 0; i < grid[0].length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < grid.length; j++) {
                list.add(grid[j][i]);
            }

            maps.put(list, maps.getOrDefault(list, 0) + 1);

            sets.add(list);
        }
        for (int i = 0; i < grid.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                list.add(grid[i][j]);
            }
            if (sets.contains(list)) {
                ans++;
                ans += maps.get(list) - 1;
            }
        }
        return ans;
    }
}

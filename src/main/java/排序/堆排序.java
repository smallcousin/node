package 排序;

import java.util.ArrayList;
import java.util.HashMap;

public class 堆排序 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,5,1,45,23,76,87,24,45};
        heapSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        System.arraycopy(nums, 0, nums, 5, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    //关键是建堆和维护堆的这个过程
    public static void siftDown(int[] nums, int n, int i) {
        int left = i * 2 + 1, right = i * 2 + 2;
        if (i > n) return ;
        int maxIndex = i;
        if (left <= n && nums[i] < nums[left]) maxIndex = left;
        if (right <= n && nums[maxIndex] < nums[right]) maxIndex = right;
        int temp = nums[i];
        nums[i] = nums[maxIndex];
        nums[maxIndex] = temp;
        if (maxIndex > i) {
            siftDown(nums, n, maxIndex);
        }
    }
    public static void heapSort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            siftDown(nums, nums.length - 1, i);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            siftDown(nums, i - 1, 0);
        }
    }

}

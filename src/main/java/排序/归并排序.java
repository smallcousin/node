package 排序;

import java.util.Arrays;

public class 归并排序 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,5,1,45,23,76,87,24,45};
        mergeSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    public static void mergeSort (int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
    public static void merge(int[] nums, int left, int mid, int right) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        int i = left, j = mid + 1;
        int num = left;
        while (i <= mid && j <= right) {
            if (copy[i] > copy[j]) {
                nums[num++] = copy[j++];
            } else {
                nums[num++] = copy[i++];
            }
        }
        while (i <= mid) {
            nums[num++] = copy[i++];
        }
        while (j <= right) {
            nums[num++] = copy[j++];
        }
    }
}

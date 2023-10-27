package 排序;

public class 快排 {
    public static void main(String[] args) {
        int[] nums = new int[]{23,45,456,2,6,234,456,2345,654,34,25};
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(nums, left, right);
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }
    public static int partition(int[] nums, int left, int right) {
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[left] <= nums[j]) j--;
            while (i < j && nums[left] >= nums[i]) i++;
            swap(nums, i, j);
        }
        swap(nums, i, left);
        return i;
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

import java.util.Arrays;

public class SingleNumberInArray {

    // Method 1: Using XOR
    public static int singleNumberUsingXor(int[] nums) {
        return findXor(0, nums);
    }

    private static int findXor(int n, int[] nums) {
        if (n >= nums.length) {
            return 0;
        }
        return nums[n] ^ findXor(n + 1, nums);
    }

    // Method 2: Using Sorting
    public static int singleNumberWithSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        
        // Using XOR method
        int resultUsingXor = singleNumberUsingXor(nums);
        System.out.println("Single number using XOR: " + resultUsingXor);

        // Using Sorting method
        int resultWithSort = singleNumberWithSort(nums);
        System.out.println("Single number using sorting: " + resultWithSort);
    }
}

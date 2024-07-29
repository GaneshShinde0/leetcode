import java.util.List;
import java.util.Collections;

class CountPairsUsingList {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums); // Sort the list
        int count = 0;
        int left = 0;
        int right = nums.size() - 1;
        
        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                count += right - left; // All pairs (left, left+1) to (left, right) will have a sum less than target
                left++; // Move the left pointer to the right
            } else {
                right--; // Move the right pointer to the left
            }
        }
        
        return count;
    }
}

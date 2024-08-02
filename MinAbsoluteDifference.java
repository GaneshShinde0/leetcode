import java.util.*;

class MinAbsoluteDifference {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        // TreeSet to maintain a sorted set of elements
        TreeSet<Integer> set = new TreeSet<>();
        int min = Integer.MAX_VALUE;
        
        // Iterate through the list
        for (int i = 0; i < nums.size(); i++) {
            // Add the current element to the TreeSet
            if (i >= x) {
                set.add(nums.get(i - x));
            }
            
            // Check the minimum difference with the current element nums[i]
            if (!set.isEmpty()) {
                // Find the closest element less than or equal to nums[i]
                Integer lower = set.floor(nums.get(i));
                if (lower != null) {
                    min = Math.min(min, Math.abs(nums.get(i) - lower));
                }
                
                // Find the closest element greater than or equal to nums[i]
                Integer higher = set.ceiling(nums.get(i));
                if (higher != null) {
                    min = Math.min(min, Math.abs(nums.get(i) - higher));
                }
            }
        }
        
        return min;
    }
}

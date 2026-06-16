class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        int n = nums.length;
        int mid = n / 2;
        
        // Find the median and partition the array using 3-way Quickselect
        quickSelect(nums, 0, n - 1, mid);
        
        long res = 0;
        if (nums[mid] < k) {
            for (int i = mid; i < n; i++) {
                if (nums[i] < k) {
                    res += k - nums[i];
                }
            }
        } else if (nums[mid] > k) {
            for (int i = mid; i >= 0; i--) {
                if (nums[i] > k) {
                    res += nums[i] - k;
                }
            }
        }
        return res;
    }

    private void quickSelect(int[] nums, int left, int right, int targetIndex) {
        if (left >= right) return;
        
        // Random pivot to maintain average O(n) performance
        int pivotIndex = left + (int)(Math.random() * (right - left + 1));
        int pivot = nums[pivotIndex];
        
        int lt = left;   // Pointer for elements < pivot
        int gt = right;  // Pointer for elements > pivot
        int i = left;    // Current scanning pointer
        
        // 3-way Partition (Dutch National Flag)
        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, i, lt);
                lt++;
                i++;
            } else if (nums[i] > pivot) {
                swap(nums, i, gt);
                gt--;
            } else {
                i++; // nums[i] == pivot
            }
        }
        
        // Now elements are grouped as: 
        // [< pivot] [== pivot] [> pivot]
        // Boundaries: [left, lt-1] | [lt, gt] | [gt+1, right]
        
        if (targetIndex >= lt && targetIndex <= gt) {
            return; // The target index falls inside the correctly placed pivot group
        } else if (targetIndex < lt) {
            quickSelect(nums, left, lt - 1, targetIndex);
        } else {
            quickSelect(nums, gt + 1, right, targetIndex);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class SolutionNLogN {

    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int mid = nums.length/2;
        long res = 0;
        if(nums[mid]<k){
            for(int i=mid;i<nums.length;i++){
                if(nums[i]<k){
                    res+=k-nums[i];
                }else{
                    break;
                }
            }
        }
        if(nums[mid]>k){
            for(int i=mid;i>=0;i--){
                if(nums[i]>k){
                    res+=nums[i]-k;
                }else{
                    break;
                }
            }
        }
        return res;
    }
}
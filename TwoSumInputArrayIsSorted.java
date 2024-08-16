class TwoSumInputArrayIsSorted {
    public int[] twoSumNaive(int[] numbers, int target) {
        
        // Following solution will brute force every possible combination
        // The input is a sorted array may be we can use it.
        // What works better while iterating on sorted arrays ? Binary Search
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                if((numbers[i]+numbers[j])==target){
                    return new int[]{i+1,j+1};
                }
            }
        }

        return new int[]{-1,-1};
    }

    public int[] twoSum(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (true) {
            int currentSum = nums[start] + nums[end];

            if (currentSum == target) {
                return new int[] {start + 1, end + 1}; 
            }

            int middle = (start + end) / 2;

            if (currentSum < target) {
                if (nums[middle] + nums[end] < target) {
                    start = middle;
                } else {
                    ++start;
                }
            } else {
                if (nums[middle] + nums[start] > target) {
                    end = middle;
                } else {
                    --end;
                }
            }
        }
    }
}

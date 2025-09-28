class Solution {
    public int largestPerimeterNaive(int[] nums) {
        // Sort the array in non-decreasing order
        Arrays.sort(nums);

        // Iterate through the array starting from the third last element
        for (int i = nums.length - 3; i >= 0; i--) {
            // Check if the three side lengths can form a valid triangle
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                // If valid, return the perimeter
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }

        // If no valid triangle can be formed, return 0
        return 0;
    }

    public int largestPerimeter(int[] nums) {
        int n=nums.length;
        bubblePartialSort(nums,--n);
        bubblePartialSort(nums,--n);
        while(n>=1){
            bubblePartialSort(nums,--n);
            if( nums[n]<(nums[n+1]+nums[n+2]) && nums[n+2]<(nums[n]+nums[n+1])) return nums[n]+nums[n+1]+nums[n+2];
        }
        return 0;
    }
    public void bubblePartialSort(int [] nums,int pos){
        int maxIndex=0;
        for(int i=0;i<=pos;i++){
            if(nums[i]>nums[maxIndex]) maxIndex=i;
        }
        int temp=nums[pos];
        nums[pos]=nums[maxIndex];
        nums[maxIndex]=temp;
    }
}
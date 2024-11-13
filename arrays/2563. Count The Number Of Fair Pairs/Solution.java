class Solution {
    public long countFairPairsInitialTLE(int[] nums, int lower, int upper) {
        // Arrays.sort(nums);
        long ans =0;
        int left = 0, n=nums.length,right =n-1;
        
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                long l = nums[i]+nums[j];
                if(l>=lower && l<=upper){
                    ans++;
                }
            }
        }
        return ans;
    }

    public long countFairPairsUsingTwoPointers(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long lower1=countPairsLessThan(nums,lower-1);
        long upper1=countPairsLessThan(nums,upper);
        return upper1-lower1;
    }

    public long countPairsLessThan(int[] arr, int target){
        long count = 0;
        int left =0;
        int right = arr.length-1;
        while(left<right){
            if(arr[right]+arr[left]<=target){
                count+=right-left;
                left++;
            }else{
                right--;
            }
        }
        return count;
    }

    long lower_bound(int[] nums, int low, int high, int element){
        while(low<=high){
            int mid = low+((high-low)/2);
            if(nums[mid]>=element){
                high = mid -1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    long countFairPairs(int[] nums, int lower, int upper){
        Arrays.sort(nums);
        long ans = 0;
        int right = nums.length-1;
        for(int i=0;i<nums.length;i++){
            // Assume we have picked nums[i] as the first pair element.
            // Low indicates the number of possible pairs with sum<lower/
            long low = lower_bound(nums, i+1,right,lower-nums[i]);
            long high = lower_bound(nums,i+1,right,upper-nums[i]+1);
            ans+=high-low;
        }
        return ans;
    }
}

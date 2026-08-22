class Solution {
    public int minimumSwaps(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i:nums){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        int res = 0, n = nums.length, left=0, right = 0;
        for(int i=0;i<n;i++){
            if(nums[i]==min){
                res+=i;
                left = i;
                break;
            }           
        }
        for(int i=n-1;i>=0;i--){
            if(nums[i]==max){
                res+=n-i-1;
                right = i;
                break;
            }           
        }
        if(right<left) res-=1; // Only once they will be swapped
        return res;
    }
}
    
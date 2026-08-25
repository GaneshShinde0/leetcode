class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        int res = 0, n = nums.length;
        Arrays.sort(nums);
        for(int i=0, j=n/2;i<n/2 && j<n;i++,j++){
            while(j<n && nums[i]*2>nums[j]) j++;
            if(j<n && nums[i]*2<=nums[j]) res+=2;
        }
        return res;
    }
}
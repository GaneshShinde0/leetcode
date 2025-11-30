class Solution {
    public int minSubarray(int[] nums, int p) {
        int remOfNums = 0;
        for(int i:nums) remOfNums = (remOfNums+i)%p;
        if(remOfNums%p==0) return 0;
        HashMap<Integer,Integer> remainderToIndex = new HashMap<>();
        remainderToIndex.put(0,-1);
        int n = nums.length;
        int sum =0;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum = (sum+nums[i])%p;
            if(remainderToIndex.containsKey((sum-remOfNums+p)%p)){
                res = Math.min(res,i-remainderToIndex.get((sum-remOfNums+p)%p));
            }
            remainderToIndex.put(sum,i);
            
        }
        return res==n?-1:res;
    }
}
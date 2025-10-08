class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(lower<nums[i]){
                res.add(Arrays.asList(lower,nums[i]-1));
            }
            lower=nums[i]+1;
        }
        if(n==0||nums[n-1]<upper)res.add(Arrays.asList(lower,upper));
        return res;
    }
}
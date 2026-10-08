class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length==0) return res;
        int n = nums.length, prev = nums[0];
        if(n==1){
            res.add(nums[0]+"");
            return res;
        }
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[i-1]+1){
                if(nums[i-1]==prev) res.add(prev+"");
                else res.add(prev+"->"+nums[i-1]);
                prev = nums[i];
            }
        }
        if(nums[n-1]!=prev){
            res.add(prev+"->"+nums[n-1]);
        }else{
            res.add(nums[n-1]+"");
        }
        return res;
    }
}
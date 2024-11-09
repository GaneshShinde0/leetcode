class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int curr = nums[0];
        List<Boolean> res = new ArrayList<>();
        for(int i=0;i<nums.length-1;i++){
            res.add(curr==0);
            curr = (2*curr+nums[i+1])%5;
        }
        res.add(curr==0);
        return res;
    }
}


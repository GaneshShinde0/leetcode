class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int curr = 0;
        for(int i:nums){
            curr=2*curr+i;
            if(curr%5==0) res.add(true);
            else res.add(false);
            curr = curr%5;
        }
        return res;
    }
}
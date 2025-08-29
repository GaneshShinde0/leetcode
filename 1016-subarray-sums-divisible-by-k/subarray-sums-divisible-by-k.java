class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int currSum = 0;
        int n = nums.length;
        int remainder = 0;
        int res = 0;
        hm.put(0,1);
        for(int i=0;i<n;i++){
            currSum+=nums[i];
            remainder = (currSum%k+k)%k;
            if(hm.containsKey(remainder)){
                res+=hm.get(remainder);
            }
            hm.put(remainder,hm.getOrDefault(remainder,0)+1);
        }
        return res;
    }
}
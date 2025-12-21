class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        int res = 0;
        hm.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            res +=hm.getOrDefault(sum-k,0);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
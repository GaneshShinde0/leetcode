class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> sumToCount = new HashMap<>();
        int sum = 0,res = 0;
        for(int i=0;i<nums.length;i++){
            sumToCount.put(sum,sumToCount.getOrDefault(sum,0)+1);
            sum+=nums[i];
            if(sumToCount.containsKey(sum-k)){
                res +=sumToCount.get(sum-k);
            }
        }
        return res;
    }
}
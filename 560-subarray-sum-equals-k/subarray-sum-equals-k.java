// Input: nums = [1,1,1], k = 2

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        int left =0, right = 0, result = 0, n = nums.length, sum = 0;
        sumToCount.put(sum,0);
        for(;right<n;right++){
            sumToCount.put(sum,sumToCount.getOrDefault(sum,0)+1);
            sum+=nums[right];
            if(sumToCount.containsKey(sum-k)){
                result+=sumToCount.get(sum-k);
            }
        }
        // if(sum==k) result++;
        return result;
    }
}
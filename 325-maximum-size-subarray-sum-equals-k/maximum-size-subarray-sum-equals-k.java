
/*
nums = [1,-1,5,-2,3]
k = 3;
=> Sum needed is 3
=> cumulative sum will become 3 at idx 4..

One step in algorithm should be 
if(hm.containsKey(sum-k)){
    res = Math.max(res, i-hm.get(sum-k));
}

Input: nums = [-2,-1,2,1], k = 1
Params:
sumToIdx: {0:-1, -2:0, -3:1, -1:2, 0:3}
sum = 0, sum-k=> -1 (Not Present)
sum = -2, sum-k=> -3 (Not Present)
sum = -3, sum-k=> -4 (Not Present)
sum = -1, sum-k=> -2 (Present and it is having index 0) i=2,
*/
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> sumToIdx = new HashMap<>();
        int res = 0, sum = 0;
        sumToIdx.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(!sumToIdx.containsKey(sum)) sumToIdx.put(sum,i);
            if(sumToIdx.containsKey(sum-k)){
                res = Math.max(res, i-sumToIdx.get(sum-k));
            }
        }
        return res;
    }
}
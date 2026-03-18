class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int currSum = 0;
        int res = 0;
        hm.put(0,1);
        for(int num:nums){
            currSum +=num;
            if(hm.containsKey(currSum-k)) res+=hm.get(currSum-k);
            hm.put(currSum, hm.getOrDefault(currSum,0)+1);
        }
        return res;
    }
}
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0, result = 0, odds = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int right = 0;right<nums.length;right++){
            if(nums[right]%2==1) odds++;
            if(hm.containsKey(odds-k)){
                result+=hm.get(odds-k);
            }
            hm.put(odds, hm.getOrDefault(odds,0)+1);
        }
        return result;
    }
}
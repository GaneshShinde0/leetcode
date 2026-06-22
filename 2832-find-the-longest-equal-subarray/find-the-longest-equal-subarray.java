class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        int res = 0, left = 0;
        for(int right = 0;right<nums.size(); right++){
            int curr = nums.get(right);
            freq.put(curr, freq.getOrDefault(curr,0)+1);
            res = Math.max(res, freq.get(curr));
            int currSize = right-left+1;
            while(currSize-res>k){
                freq.put(nums.get(left), freq.get(nums.get(left))-1);
                left++;
                currSize = right-left+1;
            }
        }
        return res;
    }
}
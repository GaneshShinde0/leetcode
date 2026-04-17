class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int res = Integer.MAX_VALUE;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int reverse = Integer.parseInt((new StringBuilder(String.valueOf(nums[i]))).reverse().toString());
            if(hashMap.containsKey(nums[i])){
                res = Math.min(res, i-hashMap.get(nums[i]));
            }
            hashMap.put(reverse,i); 
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
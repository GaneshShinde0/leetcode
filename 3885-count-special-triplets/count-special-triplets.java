class Solution {
    private static final int MOD = 1000000007;
    public int specialTriplets(int[] nums) {
        HashMap<Integer, Integer> leftMap = new HashMap<>();
        HashMap<Integer, Integer> rightMap = new HashMap<>();
        for(int i=1;i<nums.length;i++){
            rightMap.put(nums[i],rightMap.getOrDefault(nums[i],0)+1);
        }
        leftMap.put(nums[0],leftMap.getOrDefault(nums[0],0)+1);
        long res = 0;
        for(int i=1;i<nums.length-1;i++){
            rightMap.put(nums[i],rightMap.getOrDefault(nums[i],0)-1);
            if(rightMap.get(nums[i])<0) rightMap.remove(nums[i]);
            res += 1l*leftMap.getOrDefault(nums[i]*2,0)*rightMap.getOrDefault(nums[i]*2,0);
            res = res%MOD;
            leftMap.put(nums[i],leftMap.getOrDefault(nums[i],0)+1);
        }
        return (int) res;
    }
}
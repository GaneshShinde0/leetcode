class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i:nums) set.add(i);
        int res = 0;
        for(int i=0;i<nums.length;i++){
            int curr = nums[i];
            int localLength=1;
            while(set.contains(curr+1)){
                set.remove(curr);
                curr++;
                localLength++;
            }
            res = Math.max(res, localLength);
        }
        return res;
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<2) return nums.length;
        Set<Integer> treeSet = new TreeSet<>();
        for(int i:nums){
            treeSet.add(i);
        }
        int currentConsecutive=1;
        int res = 1;
        int prev = Integer.MIN_VALUE;
        for(int i:treeSet){
            if(prev+1==i){
                currentConsecutive++;
                res= Math.max(res,currentConsecutive);
            }else{
                currentConsecutive=1;
            }
            prev = i;
        }
        return res;
    }
}
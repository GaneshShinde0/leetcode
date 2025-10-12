class Solution {
    public boolean isConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int nonConsCount=0;
        for(int i:nums){
            if(set.contains(i)) return false;
            set.add(i);
        }
        for(int i:nums){
            if(!set.contains(i-1))nonConsCount++;
            if(nonConsCount>1) return false;
        }
        return nonConsCount==1;
    }
}
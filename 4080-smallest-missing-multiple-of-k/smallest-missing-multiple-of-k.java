class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums) set.add(num);
        int i = 1;
        while(set.contains(i*k)) i++;
        return i*k;
    }
}
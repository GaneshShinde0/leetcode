class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;        
    }
    public int longestConsecutiveOnLogN(int[] nums) {
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
                res = Math.max(res,currentConsecutive);
            }else{
                currentConsecutive=1;
            }
            prev = i;
        }
        return res;
    }
}
class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int currPref = nums[0], longestPref = nums[0];
        for(int i:nums) set.add(i);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==(nums[i-1]+1)){
                currPref+=nums[i];
            }else{
                currPref = nums[i];
                break;
            }
            longestPref = Math.max(currPref, longestPref);
        }
        while(set.contains(longestPref)) longestPref++;
        return longestPref;
    }
}
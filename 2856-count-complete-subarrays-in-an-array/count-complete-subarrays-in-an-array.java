class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums) set.add(i);
        int dist = set.size(), n = nums.length, res = 0;
        for(int i=0;i<n;i++){
            Set<Integer> set2 = new HashSet<>();
            for(int j=i;j<n;j++){
                set2.add(nums[j]);
                if(set2.size()==dist) res++;
            }
        }
        return res;
    }
}
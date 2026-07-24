class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] set = new boolean[2048];
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                set[(nums[i]^nums[j])]=true;
            }
        }
        Set<Integer> set2 = new HashSet<>();
        for(int i=0;i<2048;i++){
            if(set[i]) for(int num2:nums) set2.add(i^num2);
        }
        return set2.size();
    }
}

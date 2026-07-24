class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] set = new boolean[2048];
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                set[(nums[i]^nums[j])]=true;
            }
        }
        boolean[] set2 = new boolean[2048];
        int res = 0;
        for(int i=0;i<2048;i++){
            if(set[i]) for(int num2:nums){
                if(!set2[i^num2]){
                    set2[i^num2]=true;
                    res++;
                }
            }
        }
        return res;
    }
}

class Solution {
    public int[] twoSumInitialSolution(int[] nums, int target) {
        int l =nums.length;
        for(int i=0;i<l;i++){
            for(int j=i+1;j<l;j++){
                if ((nums[i]+nums[j])==target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1,-1};
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hm= new HashMap<>();
        int l =nums.length;
        for(int i=0;i<l;i++){
            int temp = target-nums[i];
            if(hm.containsKey(temp)){
                return new int[]{i,hm.get(temp)};
            }else{
                hm.put(nums[i],i);
            }
        }
        return new int[] {-1,-1};
    }
}

class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        Map<Integer,Integer> hm = new HashMap<>();
        int[] res = new int[2];
        boolean found = false;
        int prod = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int rem = target-nums[i];
            if(hm.containsKey(rem) && rem!=nums[i]){
                int idx = hm.get(target-nums[i]);
                if(prod<nums[idx]*nums[i]){
                    if(nums[i]>nums[idx]){
                        res[0]=i;
                        res[1]=idx;
                    }else{
                        res[0]=idx;
                        res[1]=i;
                    }
                    prod = nums[idx]*nums[i];
                    found = true;
                }
            }
            hm.put(nums[i],i);
        }
        if(!found) return new int[]{-1,-1};
        return res;
    }
}
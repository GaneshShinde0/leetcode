/*
k = 3
i = 2

hm = {1:1,2:1,3:1};
*/

class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        int[] res = new int[n-k+1];
        for(int i=0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            if((i-k)>=0){
                hm.put(nums[i-k],hm.getOrDefault(nums[i-k],0)-1);
                if(hm.get(nums[i-k])<=0) hm.remove(nums[i-k]);
            }
            res[Math.max(0,i-k+1)] = hm.size();
        }
        return res;
    }
}